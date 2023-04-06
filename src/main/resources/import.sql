INSERT INTO author(name) VALUES('Fulano');
INSERT INTO category(name) VALUES('Fantasia');
INSERT INTO publishing_company(name) VALUES('Seila');
INSERT INTO language(name) VALUES('Portugês');
INSERT INTO book(title, number_of_pages, isbn, release_year, author_id, publishing_company_id, category_id, language_id) VALUES('Harry Potter', 300,'213123', 2018, 1, 1, 1, 1), ('B', 300,'23434', 2020, 1, 1, 1, 1), ('W', 300,'414123', 2021, 1, 1, 1, 1);