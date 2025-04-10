INSERT INTO quiz_questions (
    question_text, category, correct_answer, time_limit_seconds,
    correct_count, incorrect_count, skipped_count, created_by_user_id, created_at, explanation
) VALUES
-- 1
(
    'Ar Seimo narius renka Lietuvos piliečiai tiesioginiuose rinkimuose?',
    'POLITIKA',
    'TAIP',
    15,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Lietuvos Respublikos Konstitucija numato tiesioginius Seimo rinkimus.'
),
-- 2
(
    'Ar Prezidentas skiria Konstitucinio Teismo teisėjus?',
    'KONSTITUCIJA',
    'TAIP',
    20,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Prezidentas skiria 3 iš 9 Konstitucinio Teismo teisėjų.'
),
-- 3
(
    'Ar Europos Parlamentas yra vykdomoji ES valdžios institucija?',
    'ES',
    'NE',
    20,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Europos Parlamentas yra teisėkūros, o ne vykdomosios valdžios institucija.'
),
-- 4
(
    'Ar savivaldybės meras skiriamas Respublikos Prezidento?',
    'SAVIVALDA',
    'NE',
    15,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Nuo 2015 metų savivaldybių merai renkami tiesiogiai gyventojų.'
),
-- 5
(
    'Ar gyventojų pajamų mokestis (GPM) yra vienodas visiems gyventojams?',
    'EKONOMIKA',
    'NE',
    25,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Lietuvoje taikomas progresinis GPM – skirtingi tarifai pagal pajamas.'
),
-- 6
(
    'Ar Konstitucinis Teismas gali panaikinti įstatymą?',
    'TEISE',
    'TAIP',
    25,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Konstitucinis Teismas gali pripažinti įstatymą prieštaraujančiu Konstitucijai.'
),
-- 7
(
    'Ar Lietuvos valstybės biudžetą tvirtina Vyriausybė?',
    'EKONOMIKA',
    'NE',
    20,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Biudžetą tvirtina Seimas, o Vyriausybė tik teikia projektą.'
),
-- 8
(
    'Ar savivaldybė gali įvesti naują nacionalinį mokestį?',
    'SAVIVALDA',
    'NE',
    15,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Mokesčių sistema reguliuojama centrinės valdžios, ne savivaldybių.'
),
-- 9
(
    'Ar ES šalių piliečiai gali balsuoti savivaldos rinkimuose Lietuvoje?',
    'ES',
    'TAIP',
    20,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Pagal ES teisę, ES piliečiai gali balsuoti savivaldos ir EP rinkimuose šalyje, kurioje gyvena.'
),
-- 10
(
    'Ar Prezidentas gali vienašališkai pakeisti Konstituciją?',
    'KONSTITUCIJA',
    'NE',
    20,
    0, 0, 0,
    0,
    CURRENT_TIMESTAMP,
    'Konstituciją gali keisti tik Seimas, laikantis griežtos procedūros.'
);
