INSERT INTO quiz_questions (
    question_text, category, correct_answer, time_limit_seconds,
    correct_count, incorrect_count, skipped_count, created_by_user_id, created_at, explanation
) VALUES
-- 1
('Ar Seimo narius renka Lietuvos piliečiai tiesioginiuose rinkimuose?', 'POLITIKA', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Lietuvos Respublikos Konstitucija numato tiesioginius Seimo rinkimus.'),
-- 2
('Ar Prezidentas skiria Ministrą Pirmininką?', 'KONSTITUCIJA', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Pagal Lietuvos Konstituciją, Prezidentas siūlo Seimui Ministrą Pirmininką.'),
-- 3
('Ar Seimas gali atšaukti Prezidentą be Konstitucinio Teismo pritarimo?', 'KONSTITUCIJA', 'NE', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Prezidentas gali būti nušalintas tik apkaltos būdu, Konstitucinis Teismas turi patvirtinti pažeidimą.'),
-- 4
('Ar Lietuvoje galima būti Seimo nariu ir meru tuo pačiu metu?', 'TEISE', 'NE', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Pagal Lietuvos įstatymus, šios pareigos nesuderinamos.'),
-- 5
('Ar PVM Lietuvoje taikomas ir paslaugoms?', 'EKONOMIKA', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'PVM taikomas tiek prekėms, tiek paslaugoms.'),
-- 6
('Ar Lietuvos kariuomenė yra integruota į NATO struktūras?', 'UZSIENIO_POLITIKA', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Lietuva yra NATO narė, ir kariuomenės daliniai integruoti į bendras struktūras.'),
-- 7
('Ar savivaldybės taryba tvirtina vietos biudžetą?', 'EKONOMIKA', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Tai viena iš svarbiausių savivaldybės tarybos funkcijų.'),
-- 8
('Ar valstybės kontrolė pavesta Teisingumo ministerijai?', 'TEISE', 'NE', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Valstybės kontrolę vykdo nepriklausoma institucija – Valstybės kontrolė.'),
-- 9
('Ar Lietuvos Respublikos Vyriausybę sudaro Seimo nariai?', 'KONSTITUCIJA', 'NE', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Vyriausybės nariai neprivalo būti Seimo nariais, nors kai kurie gali būti.'),
-- 10
('Ar teisėjai Lietuvoje skiriami visam gyvenimui?', 'TEISE', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Konstitucinis Teismas ir Aukščiausiasis Teismas turi teisėjus, skiriamus neribotam laikui iki pensijos.'),
-- 11
('Ar infliacija gali sumažinti realų atlyginimą?', 'EKONOMIKA', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Kai kainos kyla greičiau nei atlyginimai – perkamoji galia mažėja.'),
-- 12
('Ar Europos Parlamentą renka kiekvienos šalies piliečiai tiesiogiai?', 'ES', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Europos Parlamento nariai renkami tiesiogiai visose ES šalyse.'),
-- 13
('Ar Europos Komisijos pirmininką skiria Europos Taryba?', 'ES', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Pirmininką pasiūlo Taryba ir patvirtina Parlamentas.'),
-- 14
('Ar visos ES valstybės naudoja eurą kaip valiutą?', 'ES', 'NE', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Ne visos šalys prisijungė prie euro zonos (pvz., Lenkija, Vengrija, Čekija).'),
-- 15
('Ar ES sprendimai yra viršesni už nacionalinius įstatymus?', 'ES', 'TAIP', 10, 0, 0, 0, 0, CURRENT_TIMESTAMP, 'Pagal ES teisės viršenybės principą, ES teisė turi pirmenybę.');
