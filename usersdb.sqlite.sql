BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "android_metadata" (
	"locale"	TEXT
);
CREATE TABLE IF NOT EXISTS "userdetails" (
	"id"	INTEGER,
	"name"	TEXT,
	"location"	TEXT,
	"designation"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "android_metadata" ("locale") VALUES ('en_CA');
INSERT INTO "userdetails" ("id","name","location","designation") VALUES (1,'marcos
','toronto','rio'),
 (2,NULL,NULL,NULL),
 (3,NULL,NULL,NULL),
 (4,'zeca
','pagidinho','malandro'),
 (5,NULL,NULL,NULL),
 (6,NULL,NULL,NULL),
 (7,NULL,NULL,NULL),
 (8,'Carlos
','first floor','hard worh'),
 (9,'vivaldino
','araras','sargento'),
 (10,NULL,NULL,NULL),
 (11,NULL,NULL,NULL),
 (12,'marcoantony
','montain','by poluce'),
 (13,'marcoantony
','montain','by poluce'),
 (14,NULL,NULL,NULL),
 (15,NULL,NULL,NULL);
COMMIT;
