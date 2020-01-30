var express = require('express');
var bodyParser = require('body-parser');
var fs = require('fs');
var mongoclient = require('mongodb').MongoClient;
var dbConnecting = require('./dbConnect').dbConnect

var serverConnect = function () {
  var serverPort = "Your port";
  var url = "mongodb://Your Host:Your Port/Your url";
  var app = express();

  app.use(express.static('public'));
  app.use(bodyParser.json());
  app.use(bodyParser.urlencoded({ extended: false }));
  app.engine('html', require('ejs').renderFile);

  // index handling
  app.get('/', (req, res) => {  
    res.render('index.html');
  });


  //test options page
  app.get('/index', (req, res) => {  
    res.render('index.html');
  });
  
  //get all result
  app.get('/result', (req, res) => {  
    mongoclient.connect(url, { useNewUrlParser: true }, (err, client) => {
      if (err)
        throw err;

      dbConnecting(-1, 2, res, "testMDB", "testOption");
    })
  });

  //get specific result
  app.get('/report:idx', (req, res) => {
    mongoclient.connect(url, { useNewUrlParser: true }, (err, client) => {
      if (err)
        throw err;

      dbConnecting(req.params.idx, 3, res, "testMDB", "ResultTable");
    })
  })

  // people tab
  app.get('/people', (req, res) => {  
    res.render('people.html');
  });

  // favicon (returns 404)
  app.get('/favicon.ico', (req, res) => { 
    res.writeHead(404);
    res.end();
  });

  // post handling
  app.post('/postTest', (req,res) => {
    var json_string_data = req.body.data;
    
    var data = JSON.parse(json_string_data)[0];
    // Workload, ScaleFactor, CpuMemory, GpuMemory, Dimension, DBMS[], Query
    // 'data' stores post data

    res.writeHead(200);
    res.end();

    //insert option to table
    mongoclient.connect(url, { useNewUrlParser: true }, (err, client) => {
      if (err)
        throw err;

      dbConnecting(data, 1, res, "testMDB", "testOption");
    })
  });

  app.listen(serverPort, () => {
    console.log(`server running at ${serverPort}\n`);
  });
}

module.exports.serverConnect = serverConnect;