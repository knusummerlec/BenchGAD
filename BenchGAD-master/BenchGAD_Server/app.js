/**************************************************
 * Copyright (c) 2019 KNU DEAL Lab. To Present
 * All rights reserved.
 **************************************************/
//GET '127.0.0.1:3000/users/1' -v    0w0

const express = require('express');
const app = express();
const router=express.Router();
const bodyParser=require('body-parser');
const ip='your ip';
const port='your port';
//const mongo=require('mongoose');


app.listen(port,ip, () => {
  console.log('ip :'+ip+'port number'+port);
  console.log('DEAL LAB BenchGAD Project Server');
});

//app.user
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use('/users',require('./api/user'));

module.exports = app;


