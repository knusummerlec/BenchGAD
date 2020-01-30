/**************************************************
 * Copyright (c) 2019 KNU DEAL Lab. To Present
 * All rights reserved.
 **************************************************/
const express = require('express');
const router=express.Router();
const controller = require('./user.controller'); // controller call
const mongo=require('mongoose'); // moongoose 패키지 사용

// router crud call 
router.get('/users',controller.index);
router.get('/users/:id',controller.show);
router.delete('/users/:id',controller.destroy);
router.post('/users',controller.create);


//req client->server res server->client

// connect to MongoDB / the name of DB is set to 'myDB_1'
mongo.connect('mongodb://localhost/Bench_Test1');
 
// we get the pending connection to myDB running on localhost
var db = mongo.connection;

// we get notified if error occurs
db.on('error', console.error.bind(console, 'connection error:'));
// executed when the connection opens
db.once('open', function callback () {
    // add your code here when opening
      console.log("open");
});

// creates DB schema
//** jackson lib 사용시 대문자->소문자화됨 조심
var userSchema = mongo.Schema({
	project_name: String,
    scale_factor : Number,
    transaction_refresh_rate: Number,
    gpu_use : Boolean,
    cpu_count : Number,
    text : String,
    dbnum : Number,
    dblist : Array,
    iteration_num : Number,
    status : Number, // status 0 : init status 1 : working status 2 : done
	exp_result : String
});
/*
	status 0 은 처음 experiment 를 생성하여 디비에 저장될떄 0이며 mapd 에서는 오로지 status 0 인 정보만 받아와서 작업한다. 이때 받아온 정보들의 status 는 1이된다. 
	status 2는  mapd 가 실험을 끝낸뒤 result 를 생성할시 정보가 디비에 저장될때 2 로 바뀐다.
*/


//schema method speak : for checking
userSchema.methods.speak=function(){
	var greeting=this.text
	?"Saved at Server "+this.text
	:"I don't have a name"
	console.log(greeting);
}
// compiels our schema into a model
var User = mongo.model('User', userSchema);

//client want result from server 
router.get('/:project_name/out',(req,res)=>{
	console.log('get project input info');
	console.log(req.params.project_name);
	const name=req.params.project_name;

	if(!name){
		return res.status(400).json({error:'Incorrect name'});
		// function chaining 함수 체이닝 status 호출후 바로 json 감
	}
	//moongoose method find info from server
	User.findOne({'project_name':req.params.project_name,'status':2},function(err,user){
		
		if(err){
			console.err(err);
			throw err;
		}
		console.log(user);
		return res.json(user);
	});

	
});
 

//GET /users 전체
router.get('/', (req, res) => {

  User.find(function(err,users){
	if(err) return console.error(err);
	//console.log(userSchema);
	console.log("find()- "+users)
	return res.json(users);
 	});
});


//GET /users/1 2 ... //id 구분법 
router.get('/:project_name',(req,res)=>{
	console.log('get project input info');
	console.log(req.params.project_name);
	const name=req.params.project_name;

	if(!name){
		return res.status(400).json({error:'Incorrect name'});
		// function chaining 함수 체이닝 status 호출후 바로 json 감
	}

	User.findOne({'project_name':req.params.project_name},function(err,user){
		
		if(err){
			console.err(err);
			throw err;
		}
		console.log(user);
		
		return res.json(user);
	});

});

//mapd -> server req change status
router.get('/:status/ch',(req,res)=>{
	console.log('update data status');
	console.log(req.params.status);
	const stat=req.params.status;
	let comp=0;
	if(!stat){
		return res.status(400).json({error:'Incorrect stat'});
		// function chaining 함수 체이닝 status 호출후 바로 json 감
	}
	
	if(stat=='200')
	{
		User.find({'status':0},function(err,user){		
		if(err){
			console.err(err);
			throw err;
		}
		console.log(user);
		return res.json(user);
		});
		User.updateMany({status:0},{status:1},function(err,user){
				//console.log(user);
				//return res.json(user);
		});
	}

});



//DELETE. /users/1 2... 

router.delete('/:project_name',(req,res)=>{
	const id=parseInt(req.params.id,10);
	if(!id){
		return res.status(400).json({error: 'Incorrect id'});
	}

	const userIdx=users.findIndex(user=>user.id===id);
	if(userIdx===-1){
		return res.status(404).json({error:'Unknown user'});
	}

	users.splice(userIdx,1);
	res.status(204).send();
});

//POST /users
// mapd -> server 
// curl -X POST '127.0.0.1:3000/users' -d "name=daniel" -v
router.post('/result',(req,res)=>{
//router.get('/:project_name/result',(req,res)=>{
	console.log('from mapd excuter');
	console.log(req.body.project_name);
	console.log(req.body.exp_result);
	//find and update params
	User.findOneAndUpdate({project_name:req.body.project_name},{exp_result:req.body.exp_result,status:2},{multi:true},function(err,user)
			{
				console.log(user);
				if(user==null)
				{
					comp=1;
					console.log('nothing to change');

				}
			});


});



//client -> server get file from client and save at MondoDB
router.post('/',(req,res)=>{
	const np = new User();
	
	np.project_name=req.body.project_name;
	np.scale_factor=req.body.scale_factor;
	np.transaction_refresh_rate=req.body.transaction_refresh_rate;
	np.gpu_use=req.body.gpu_use;
	np.cpu_count=req.body.cpu_count;
	np.text=req.body.text;
	np.dbnum=req.body.dbnum;
	np.dblist=req.body.dblist;
	np.iteration_num=20;
	np.status=0;
	
	//save info at mongodb
	np.save(function (err, user1) { 
  	if (err) // TODO handle the error
      console.log("error");
  	user1.speak();
	});

	return res.status(201).json(np);
});





module.exports=router;
