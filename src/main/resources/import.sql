-- "predefined" data
insert into server(id,name,description) select server_seq.nextval,'MyServer','Small and Shiny' from dual;
insert into server(id,name,description) select server_seq.nextval,'YourServer','Big and Rusty' from dual;