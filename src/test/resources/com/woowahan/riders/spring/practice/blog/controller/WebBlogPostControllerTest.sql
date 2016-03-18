insert into writer (id, nickname) values (1, 'sonegy');
insert into site (id, endpoint, writer_id) values (1, 'sonegy', 1);
insert into post (id, content, created_date_time, site_id, title, writer_id) values (1, 'content1', null, 1, 'title1', 1);
insert into post (id, content, created_date_time, site_id, title, writer_id) values (2, 'content2', null, 1, 'title2', 1);
