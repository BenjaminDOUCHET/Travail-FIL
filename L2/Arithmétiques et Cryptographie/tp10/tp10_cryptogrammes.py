#!/usr/bin/python3
# -*- coding: utf-8 -*-

"""
:cours: MIAC 2018-2019, groupe 11
:auteur: enseignant du groupe 11

Quelques cryptogrammes à décrypter. Tous ont été obtenus par un
chiffrement de Vigenère, à partir de clairs formés des caractères d'un
alphabet de la classe alphabet, contenant le caractère espace.

Pour chacun de ces cryptogrammes, utiliser la méthode des distances entre
trigrammes pour deviner la longueur de la clé. Une fois la longueur de la clé
connue, vous pourrez utiliser une procédure par analyse de fréquences comme
la procédure decrypte_vigenere_taille_connue() de la séance d'aujourd'hui.

"""

from alphabet import Alphabet

ALPHABET1 = Alphabet((" ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                      "abcdefghijklmnopqrstuvwxyz"
                      "àéèêëîùûç,;:.!?'0123456789+-^*/"))
ALPHABET2 = Alphabet((" ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                      "abcdefghijklmnopqrstuvwxyz"
                      "àéèêëîùûçô,;:.!?'0123456789+-^*/’"))

CRYPTOGRAMMES = [
    'SPEGBRWBRZP  L  CMKEMWPGWWRGQDHYPHTEGNAUCFPDGLCMLYMHCELXOSPRGYN TAULYLKPVYEPORYL  KCAPMSTTUZDHYPLKYVEOSTMVEMSPMTPBYTEGORZKQYZV CMKPMSSATXRGCAUDMSPEGCRAWRZKPHEELCMKPEGXNSSRABEG GIWVJCMLDMKPMSLMJZDYEB TAUKQLCMNZGBPDUPZLYFZKAUDMYPEVWGGORD AZPDGONUCMAYRGORJWNYLFPZ GCASP UPYSPMSPEGODVTFZK HDGYPYZKVULYPP HMYLCMLDMZLPYPEGORGWUVXZLKNMT GAGLKPLDFLKQLNYHBN TAUKPVYE LZTP  KBYPELYFLKNGDAACMSPEGXRTMDLCMKEMJZDWCMZZPPLYGWRABMYLBWPYSPMZL ZKPLCELKYLEDZKQYZV CMLDMSPGYCMKPHVTDZKMHQVUKCAPMSPEGLP PEGOGG AAFAPBMSPTPCYHDVMKR KPLEJGOGG AAFAPBMLHRJEFPQMWZGBL  KR BRGLMJSNXERGT ZDNUDMJZZWLDLCMHFRJKYLKOADMKPM ZG PMPYE TFADVVYMWZYPDVXERGP GCAPP  KBSEEGBRZ RJDRZKMHQVUKCAPMSPEGBRJWNTLFPZ ZKQLCMJTFVIRUCMMZ KPRZKQLCAYXNPCMZEDGORZKBYT JTBLCMZTZWWRZKR KVUNAUDRZDNIWRZKFVEDUP  KFVEWVEDZKNAKZHT  TRUKQLKYHKPVYE TFADVVYMLDMHEMIZ OPGYKQLKFVEE',

    # utilise ALPHABET1
    ("R6s'ç/Qpz8,/v3ëkù s6z'Q*rk;229ç3vku'Q6rkç'è:;3.3;GQ^v*"
     ";^v3ë/vkv8Q7z6è'Q8v wkt'ë/Q!z8ûkv/Q*rk;229ç3vku'Q6rkx^"
     "rAz/r/z9ëku3;'Q^v6r/zAz/2kxGëGç:è'Q'ëkê3è6vkë':0Q!v8;k"
     ",'zEvRQtèkt9ë/ç3s vkè:ç1v7v8;kr Q?2Av6î+ù'ê'ë/Q?vkè:Q7"
     "2!r8z-:'Q-::ë/z-:'Q';ku'Q6rkt9,7î6î1z'+kv/Q^vNî3;kè'Q+"
     "ç3?ke9s'èku'Q+yD,3û vku'Q7z6è'Q8v wkt'ë/QAz8x/M';g:8Q+"
     "î çk,9ëkvCù6z!r/z9ëku'Q6A'w0v/Q+y9;926v!;^z-:'*kj9ëk;^"
     "rAr3èkv*;kë9;:ê7v8;kt9ë8:ku Q1ç:ë?Q+:.è3tkù9:^Q6AGû r/"
     "z9ëkVk21r6vkêkw9z*Q!Q::kt:ç^2OQ-:3QG;:s6z/Q ë'QGû zAr6"
     "v8t'Q'ë/ç'Q6rkê:;33^vkv/Q6AGë'ç1z'Q?A ëk,D,/37vR"),

    # utilise ALPHABET2
    "Ww,+Iré9fTsèûfWCiè9Wiz9fPiàP.Squu7;hG05Ymxq:IDXû,Rrmê8;hmçfEpjq8Vsà9fZeàô,WDwy7Ieè.fHiàP1Ivà9f-yqP7Ymêu2X!Hy2Hstu2XwHs3Qtiw2SràPôIDêë*Ekm9f6iHêùZmzufKpqç7EréP7YvHé,WDoë9Jjzu7;euu6W0HPg;tmy2IDtu7;svôaMpàPôftwç WDà,6;pmçfTpiêçLià9f-ymPçIwHû3MwHt,;pGq/Yv1P1Epit6SméçfIxHx3Rxm,^oDTq!Wwmê8;tqô,Ywmè,RxHé,YvàP:Vevt,WDiy0IwHr0Erkx,WDKë1QiHt,WDi;!VsvçfXvi42IvH'fG.é0fHCm,^rDHS,;zw!ùKièûfEmt0I;gwè1IDqéfIwéP:Eykx,;iéP+IytufsDT,!oDvq:YùzufWmHr,Ey1P5YCqéfIwéPçSqqù9IDmôfPeqtfsDTO9RDiwùGiHç3RDjuç;eêuç;yvPûV;tuaKym,0I!HbeEyéû,;qqè,oDmêfFsqôùRx1P0,mvv!VqmP5YmH;3PeqôfsDHb,;Tw18IDmç8;wmèûPejé,;eèP4Vmvs,;hmçfRyôu7;UèyfLevô,;piP8Iqx28IDmôfWiHû!XDlufPCiûçLizPJ;Iîy0fDà,6;pmP7SpHq9;qqé!IyHt,WDp, Iw1PyIwHq!PiàPôIDo0ùRxHéeIqx2çLivôfHiHèùVgpu6r",

    'N?T^"?P[w%Dm-)Txn.`n{/S]r2F]-#Pey%Dmv/Ox|&`]v3Ub{#Uxu!Tan"M^-/Ccr#Ul;?$hz-Pg-5T^!?Jgp,V]r?N^z"Fk!(Ji-4Fl")O`9?S^z/Wb{\'`]#0Mbp!U^!?Gk|-`Z-3Fj#%O\\rK`Z{$`\\|-Qn")O`--Bmu%NZ")DZy?Pir2Bmv/Ol-3V\\u?Bl-)Omr2T^p4Jh{K`n{)Pg9?Ebs&Fkr.D^9?Bgq?Trz-Fm )Dxq)G_r2Fgp%nx5ePk-/Uar2`\\|.UZv.Fk!?T^r?Uar?Cnv,U&v.`]v#U%-,Jl"K`Z{$`m#0M^-#MZ!3Fl9?Bgq?Uar?Dhy,F\\")Pg!?Nhq5M^;H`x-kJdr?Pmu%Sxp/Mer#Ub|.T%-3Fm!?Tn}0Pk"?Yxv.`lr4lxy%O!!%U"9?Bgq?Gh ?Yxv.`lr4nxO%Jgt?Bg-5Oh $Fkr$`\\|,M^p4Jh{K`lr4Txq/`g|4`kr#Pkq?Fer-Fg"?Qh!)Ub|.`h ?Pkq%Sx|&`b{3Fk")Pg;?"\\p/S]v.He\'K`lr4Txq/`g|4`l#0Qh 4`b{$Fqv.H%-3Mbp)O`9?Pk-/Uar2`lr1V^{#F&y)L^-"Fan6Jh M`x-sI^ %`Z %`\\#2S^{4Mr-4Xh-"Vby4mb{?T^"?Ur}%T%-3Fm-!O]-&Sh(%Olr4nxa(Fx!%Ux"9Q^-)Txz5UZo,Fx:L`mu%`\\|.U^{4Txp!Oxo%`\\u!O`r$`n!)O`--Fmu/El-,Jdr?B]qGixn.Ex %Nh$%h";?4b{#Fxv4`b!?Nn"!CerK`b"?IZ!?Oh-(Blu?WZy5Fxn.Exp!Og|4`[r?Vlr$`Z!?Fb"(Fk-!`]v#Ub|.Bk\'?L^\'?Pk-!Txn.`^y%N^{4`hs?Bg|4I^ ?T^"M`Mu%`_ /[^{3Fm-4Zir?Jl-)Nf#4B[y%`Z{$`an3IZo,Fx:L`b"3`\\|.U^{4Txp!Og|4`[r?Be"%S^q?B_"%Sxv4`b!?Dkr!U^qZ`b"?DZ{?Uar2F_|2Fxo%`n!%Exn3`Z-$J\\")Pgn2Zxx%Zx|2`Z!?Bg-%M^z%Om-/Gxn.Pmu%Sx!%U\'-?`G|.m^z0Ur-3Fm!?hg|4`_ /[^{3Fm!H`\\n.`[r?Dkr!U^q?Cr-0MZp)O`-!`\\|-NZ:3Fin2Bmr$`ev3Ux|&`^y%N^{4Tx%)Uav.`[ !D^!K`_|2`^&!Niy%zx)FKZp+g%-FTc|%S]4=lxv.`Zq$Jmv/Ox"/`mu%`lr4`\\|.Tm 5Dm|2n'
]
