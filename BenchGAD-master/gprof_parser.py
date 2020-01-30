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
for i in range(0,5):
        lines = f.readline()

name = sys.argv[1][0:-4]

db = pymysql.connect(host='localhost', port=3306, user='dkelab', passwd='dkelab522', db='benchGAD', charset='utf8')

cursor = db.cursor()
try :

	sql = """
        CREATE TABLE """+ name + """(
            time_rate FLOAT,
            cumulative_second FLOAT,
            self_seconds FLOAT,
            calls INTEGER,
            self_ms_per_call FLOAT,
            total_ms_per_call FLOAT,
            name BLOB NOT NULL
            );
            """
	cursor.execute(sql)
	
	while True :
		lines = f.readline()
		line = lines.split()
		word = [x for x in line if x]
		if not lines:
			break
		if not word:
			break
		if word[0] == '%':
			break
		print(word[0])
		if lines[33] == ' ':
			sql = """INSERT INTO """ + name + """ (time_rate, cumulative_second, self_seconds, name ) VALUES ('"""
			for j in range(3) :
				sql += word[j]
				sql += "', '"
			sql += str(lines[54:len(lines)-1])
			sql += "')"

		else :
			sql = """INSERT INTO """ + name + """ (time_rate, cumulative_second, self_seconds, calls, self_ms_per_call, total_ms_per_call, name ) VALUES ('"""
			for j in range(6):
				sql += word[j]
				sql += """', '"""
			sql += str(lines[54:len(lines)-1])
			sql += """')"""	
		cursor.execute(sql)
#print(sql)
	db.commit()
finally :
	db.close()
f.close()
