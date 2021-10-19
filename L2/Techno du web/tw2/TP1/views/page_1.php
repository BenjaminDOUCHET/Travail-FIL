<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Premier exercice PHP</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="iniPHP.css" />
    </head>
    <body>
        <header>
            <h1>Premier exercice PHP</h1>
            <h2>Réalisé par <span class="nom">Benjamin DOUCHET</span></h2>
        </header>
        <!-- section résultat. Créer une section pour chaque question -->
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>Nous sommes le <?= date('d / m / Y') ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>test pour $n = 2 et $s = 'the quick brown fox'</p>
            <p><?= afficheVar(2 , 'the quick brown fox') ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>test pour $n = 3 et $texte = 'the quick brown fox'</p>
            <p><?= n_parag('the quick brown fox',2) ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>test pour $texte = 'the quick brown fox'</p>
            <p><?= diminue('the quick brown fox') ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>test pour $texte = 'the quick brown fox'</p>
            <p><?= diminue('the quick brown fox') ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>test pour table multiplication de 2</p>
            <p><?= tableMultiplication(2) ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>test pour table multiplication de 2</p>
            <p><?= tablesMultiplication() ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>test pour table multiplication en tableau</p>
            <p><?= tableauMult() ?></p>
        </section>




    </body>

</html>
