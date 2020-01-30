'''
**************************************************
* Copyright (c) 2018 KNU DKE Lab. To Present
* All rights reserved. 
**************************************************
'''
#python3 gprof_parser.py filename.txt
import sys
import pymysql

f = open(sys.argv[1],'r')
for i in range(0,4):
        lines = f.readline()

name = sys.argv[1][0:-4]

db = pymysql.connect(host='localhost', port=3306, user='dkelab', passwd='dkelab522', db='benchGAD', charset='utf8')
'''
CREATE TABLE CUPTI_TYPE ( type_id INTEGER NOT NULL, type_name VARCHAR(20) );
ALTER TABLE CUPTI_TYPE MODIFY COLUMN type_id int PRIMARY KEY;
'''

cursor = db.cursor()
try :

	sql = """
        CREATE TABLE """+ name + """(
            Type_id INT,
			Time_rate FLOAT,
            Time_ms FLOAT,
            Calls INTEGER,
            Avg FLOAT,
            Min FLOAT,
			Max FLOAT, 
            Name BLOB NOT NULL
            );
            """
	cursor.execute(sql)
	print(sql)
	typeid = 0
	start = 0
	while True :
		start = 0
		lines = f.readline()
		line = lines.split()
		word = [x for x in line if x]
		if not lines:
			break
		if not word:
			break
		if word[0] == "GPU":
			typeid = 1
			start = 2
		if word[0] == "API":
			typeid = 2
			start = 2
		sql = """INSERT INTO """ + name + """ (Type_id, Time_rate, Time_ms, Calls, Avg, Min, Max, Name ) VALUES ('"""
		sql += str(typeid)
		sql += """', '"""
		for j in range(6):
			if j == 0 :
				sql += word[j+start][0:-1]
			elif j == 2 :
				sql += word[j+start]
			else :
				sql += word[j+start][0:-2]
			sql += """', '"""
		sql += str(lines[77:len(lines)-1])
		sql += """')"""	
		print(sql)
		cursor.execute(sql)
#	print(sql)
	sql = "ALTER TABLE " + name + " ADD FOREIGN KEY (Type_id) REFERENCES CUPTI_TYPE (type_id)"
	cursor.execute(sql)
	db.commit()
finally :
	db.close()
f.close()
