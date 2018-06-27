delimiter $$
create procedure total_writen_author_books(first_name varchar(50),last_name varchar(50))
begin
   select count(b.book_id)
   from books as b
   join authors as a on b.author_id=a.author_id
	where a.first_name = first_name and a.last_name=last_name;
end
$$
