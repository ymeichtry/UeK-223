-- Kategorien hinzufügen
INSERT INTO Category (id, title) VALUES (1, 'Work');
INSERT INTO Category (id, title) VALUES (2, 'Personal');
 
-- Tags hinzufügen
INSERT INTO Tag (id, title) VALUES (1, 'Urgent');
INSERT INTO Tag (id, title) VALUES (2, 'Optional');
 
-- Einträge hinzufügen, nachdem Kategorien existieren
INSERT INTO Entry (id, checkIn, checkOut, category_id) VALUES (1, '2024-11-04T10:00:00', '2024-11-04T12:00:00', 1);
INSERT INTO Entry (id, checkIn, checkOut, category_id) VALUES (2, '2024-11-03T09:00:00', '2024-11-03T11:00:00', 2);
 
-- Verknüpfungen zwischen Einträgen und Tags
INSERT INTO entry_tags (entry_id, tag_id) VALUES (1, 1);
INSERT INTO entry_tags (entry_id, tag_id) VALUES (2, 2);