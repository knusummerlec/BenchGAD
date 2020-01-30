var mongoose = require('mongoose');

//check == 1 (insert), check == 2 (get result info(result)), check == 3 (get specific result info(report))
async function dbConnect(jsonObject, check, res, dbn, coln) {
    var url = "mongodb://your host:your port/";
    var db = mongoose.connection;

    //connect the db   
    db.on('error', function () {
        console.log('===Connection Failed===\n');
    });

    db.once('open', function () {
        console.log('===Connection Succeeded===\n');
    });

    //db, collection
    var dbName = dbn
    var collectionName = coln

    mongoose.connect(url, { useNewUrlParser: true, dbName: dbName }, function (error, db) {
        if (error) {
            console.log("connection error:" + error);
        }
        else {
            if (check == 1) {     //insert data to db collection
                db.collection(collectionName).insertOne(jsonObject, function (err, res) {
                    if (err) {
                        console.log("Some problems occured while inserting!");

                        throw err;
                    }
            
                    console.log("1 document inserted to mongoDB");

                    db.close();
                });
            }
            else if (check == 2) {    //get data from db collection
                db.collection(collectionName).find({}).toArray().then((docs) => {
                    res.render('result.html', {
                        data: docs,
                    });
                }).catch((err) => {
                    console.log(err);
                }).finally(() => {
                    //
                });
            }
            else if (check == 3) {    //get specific data from db collection
                //temporarily implement(조건 변경 필요)
                db.collection(collectionName).find({ "Invocation": "6" }).toArray().then((docs) => {
                    res.render('report.html', {
                        data: docs,
                        idx: jsonObject,
                    });
                }).catch((err) => {
                    console.log(err);
                }).finally(() => {
                    //
                });
            }
        }
    });
}

module.exports.dbConnect = dbConnect;