package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import mike.kor.capitalcountry.model.Capital;
import mike.kor.capitalcountry.model.Country;

public class Tren_All extends AppCompatActivity {

    //Создаём переменную для текстового поля @+id/text_roll для последующего вывода очередной страны и удаляем поле text:
    private TextView rText;

    //Создаём переменные для кнопок @+id/but_1, @+id/but_2, @+id/but_3 и @+id/but_4 и
// удаляем поле text. В эти кнопки будут вписаны называния столиц для выбора
    private Button but_cap_1;
    private Button but_cap_2;
    private Button but_cap_3;
    private Button but_cap_4;

    //Создаём 4 тестовые временные переменные для вывода на экран значений, которые выдаёт
// программа. Эти значения будут использованы для мотивации в случае правильного ответа и
// справки, в случае ошибки
    private TextView show_1;
    private TextView show_2;
    private TextView show_3;
    private TextView show_4;

    //Создаём 4 переменных для записи значений, получаемых в результате работы кнопок.
// Эти переменные нужны для хранения данных, полученных в результате нажатия кнопок. Дело
// в том, что много кода пока что расположено в кнопках (пища для рефакторинга). И переменные
// нужны для обновления данных в кнопках, так как после нажатия там остаются старые значения,
// что приводит к искажению проверки правильности выбранного варианта ответа
    int num_1 = 0;
    int num_2 = 0;
    int num_3 = 0;
    int num_4 = 0;

    //Переменная, которая определяет количество вопросов в тренировке (на самом деле, реально
// вопросов на 1 больше, но мы начинаем с 0, поэтому и 19, а не 20).
    int num_questions = 242;

    //Создаём 2 переменные для подсчёта правильных и неправильных ответов во время нажатия кнопок
    int num_correct;
    int num_incorrect;

    //Создаём 2 переменные для текстового поля @+id/num_correct and @+id/num_incorrect, это будут
// выводиться на экран результаты верных или ошибочных ответов, в числовом выражении. Т.е.
// количество верных/неверных ответов можно будет наблюдать во время прохождения тестированя
    private TextView num_correct_t;
    private TextView num_incorrect_t;

    //Добавляем переменную для текстового поля answerCheck, где будет появлятся результат нажатия
// кнопки - правильный или неправильный ответ. Текстовое поле располагаем
// в linearLayout(horizontal), там где у нас кнопки, под ними. В файле strings добавляем 3 поля:
//    <string name="wait_answer">Нажмите кнопку с вариантом столицы</string>
//    <string name="correct_answer">Верный ответ!</string>
//    <string name="incorrect_answer">Ошибка</string>
    private TextView anCheck;

    //Создаём генератор случайных занчений
    Random random = new Random();

    //Создаём список listC на основе класса Country из каталога model, откуда мы
// будем брать значения стран
    private final Country[] listC = new Country[]
            {
                    new Country(R.string.country_All_Abkhazia_0),
                    new Country(R.string.country_All_Australia_1),
                    new Country(R.string.country_All_Austria_2),
                    new Country(R.string.country_All_Azerbaijan_3),
                    new Country(R.string.country_All_Azores_4),
                    new Country(R.string.country_All_AlandIslands_5),
                    new Country(R.string.country_All_Albania_6),
                    new Country(R.string.country_All_Algeria_7),
                    new Country(R.string.country_All_Anguilla_8),
                    new Country(R.string.country_All_Angola_9),
                    new Country(R.string.country_All_Andorra_10),
                    new Country(R.string.country_All_AntiguaAndBarbuda_11),
                    new Country(R.string.country_All_Argentina_12),
                    new Country(R.string.country_All_Armenia_13),
                    new Country(R.string.country_All_Aruba_14),
                    new Country(R.string.country_All_Afghanistan_15),
                    new Country(R.string.country_All_Bahamas_16),
                    new Country(R.string.country_All_Bangladesh_17),
                    new Country(R.string.country_All_Barbados_18),
                    new Country(R.string.country_All_Bahrain_19),
                    new Country(R.string.country_All_Belize_20),
                    new Country(R.string.country_All_Belarus_21),
                    new Country(R.string.country_All_Belgium_22),
                    new Country(R.string.country_All_Benin_23),
                    new Country(R.string.country_All_Bermuda_24),
                    new Country(R.string.country_All_Bulgaria_25),
                    new Country(R.string.country_All_Bolivia_26),
                    new Country(R.string.country_All_BonaireStEustatiusAndSaba_27),
                    new Country(R.string.country_All_BosniaAndHerzegovina_28),
                    new Country(R.string.country_All_Botswana_29),
                    new Country(R.string.country_All_Brazil_30),
                    new Country(R.string.country_All_Brunei_31),
                    new Country(R.string.country_All_BurkinaFaso_32),
                    new Country(R.string.country_All_Burundi_33),
                    new Country(R.string.country_All_Butane_34),
                    new Country(R.string.country_All_Vanuatu_35),
                    new Country(R.string.country_All_Vatican_36),
                    new Country(R.string.country_All_GreatBritain_37),
                    new Country(R.string.country_All_Hungary_38),
                    new Country(R.string.country_All_Venezuela_39),
                    new Country(R.string.country_All_VirginIslandsNortheastBritishDependency_40),
                    new Country(R.string.country_All_VirginIslandsSouthwestUSA_41),
                    new Country(R.string.country_All_EastTimor_42),
                    new Country(R.string.country_All_Vietnam_43),
                    new Country(R.string.country_All_Gabon_44),
                    new Country(R.string.country_All_Guyana_45),
                    new Country(R.string.country_All_Haiti_46),
                    new Country(R.string.country_All_Gambia_47),
                    new Country(R.string.country_All_Ghana_48),
                    new Country(R.string.country_All_Guadeloupe_49),
                    new Country(R.string.country_All_Guatemala_50),
                    new Country(R.string.country_All_Guiana_51),
                    new Country(R.string.country_All_Guinea_52),
                    new Country(R.string.country_All_GuineaBissau_53),
                    new Country(R.string.country_All_Germany_54),
                    new Country(R.string.country_All_Guernsey_55),
                    new Country(R.string.country_All_Gibraltar_56),
                    new Country(R.string.country_All_Honduras_57),
                    new Country(R.string.country_All_HongKong_58),
                    new Country(R.string.country_All_Grenada_59),
                    new Country(R.string.country_All_Greenland_60),
                    new Country(R.string.country_All_Greece_61),
                    new Country(R.string.country_All_Georgia_62),
                    new Country(R.string.country_All_Guam_63),
                    new Country(R.string.country_All_EquatorialGuinea_64),
                    new Country(R.string.country_All_Denmark_65),
                    new Country(R.string.country_All_Jersey_66),
                    new Country(R.string.country_All_Djibouti_67),
                    new Country(R.string.country_All_Dominica_68),
                    new Country(R.string.country_All_DominicanRepublic_69),
                    new Country(R.string.country_All_Egypt_70),
                    new Country(R.string.country_All_Zambia_71),
                    new Country(R.string.country_All_Zimbabwe_72),
                    new Country(R.string.country_All_WesternSahara_73),
                    new Country(R.string.country_All_Israel_74),
                    new Country(R.string.country_All_India_75),
                    new Country(R.string.country_All_Indonesia_76),
                    new Country(R.string.country_All_Jordan_77),
                    new Country(R.string.country_All_Iraq_78),
                    new Country(R.string.country_All_Iran_79),
                    new Country(R.string.country_All_Ireland_80),
                    new Country(R.string.country_All_Iceland_81),
                    new Country(R.string.country_All_Spain_82),
                    new Country(R.string.country_All_Italy_83),
                    new Country(R.string.country_All_Yemen_84),
                    new Country(R.string.country_All_CapeVerde_85),
                    new Country(R.string.country_All_Kazakhstan_86),
                    new Country(R.string.country_All_Cambodia_87),
                    new Country(R.string.country_All_Cameroon_88),
                    new Country(R.string.country_All_Canada_89),
                    new Country(R.string.country_All_CanaryIslands_90),
                    new Country(R.string.country_All_Qatar_91),
                    new Country(R.string.country_All_Kenya_92),
                    new Country(R.string.country_All_Cyprus_93),
                    new Country(R.string.country_All_NorthernCyprus_94),
                    new Country(R.string.country_All_Kyrgyzstan_95),
                    new Country(R.string.country_All_Kiribati_96),
                    new Country(R.string.country_All_China_97),
                    new Country(R.string.country_All_Colombia_98),
                    new Country(R.string.country_All_Comoros_99),
                    new Country(R.string.country_All_Congo_100),
                    new Country(R.string.country_All_DemocraticRepublicOfTheCongoFormerZaire_101),
                    new Country(R.string.country_All_KoreaNorth_102),
                    new Country(R.string.country_All_KoreaSouth_103),
                    new Country(R.string.country_All_KosovoRepublicOfKosovo_104),
                    new Country(R.string.country_All_CostaRica_105),
                    new Country(R.string.country_All_IvoryCoast_106),
                    new Country(R.string.country_All_Cuba_107),
                    new Country(R.string.country_All_Kuwait_108),
                    new Country(R.string.country_All_Curacao_109),
                    new Country(R.string.country_All_Laos_110),
                    new Country(R.string.country_All_Latvia_111),
                    new Country(R.string.country_All_Lesotho_112),
                    new Country(R.string.country_All_Liberia_113),
                    new Country(R.string.country_All_Lebanon_114),
                    new Country(R.string.country_All_Libya_115),
                    new Country(R.string.country_All_Lithuania_116),
                    new Country(R.string.country_All_Liechtenstein_117),
                    new Country(R.string.country_All_Luxembourg_118),
                    new Country(R.string.country_All_Mauritius_119),
                    new Country(R.string.country_All_Mauritania_120),
                    new Country(R.string.country_All_Madagascar_121),
                    new Country(R.string.country_All_Madeira_122),
                    new Country(R.string.country_All_Mayotte_123),
                    new Country(R.string.country_All_NorthMacedonia_124),
                    new Country(R.string.country_All_Malawi_125),
                    new Country(R.string.country_All_Malaysia_126),
                    new Country(R.string.country_All_Mali_127),
                    new Country(R.string.country_All_Maldives_128),
                    new Country(R.string.country_All_Malta_129),
                    new Country(R.string.country_All_Morocco_130),
                    new Country(R.string.country_All_Martinique_131),
                    new Country(R.string.country_All_MarshallIslands_132),
                    new Country(R.string.country_All_Mexico_133),
                    new Country(R.string.country_All_Mozambique_134),
                    new Country(R.string.country_All_Moldova_135),
                    new Country(R.string.country_All_Monaco_136),
                    new Country(R.string.country_All_Mongolia_137),
                    new Country(R.string.country_All_Montserrat_138),
                    new Country(R.string.country_All_Myanmar_139),
                    new Country(R.string.country_All_Namibia_140),
                    new Country(R.string.country_All_Nauru_141),
                    new Country(R.string.country_All_Nepal_142),
                    new Country(R.string.country_All_Niger_143),
                    new Country(R.string.country_All_Nigeria_144),
                    new Country(R.string.country_All_Netherlands_145),
                    new Country(R.string.country_All_Nicaragua_146),
                    new Country(R.string.country_All_Niue_147),
                    new Country(R.string.country_All_NewZealand_148),
                    new Country(R.string.country_All_NewCaledonia_149),
                    new Country(R.string.country_All_Norway_150),
                    new Country(R.string.country_All_UnitedArabEmirates_151),
                    new Country(R.string.country_All_Oman_152),
                    new Country(R.string.country_All_CaymanIslands_153),
                    new Country(R.string.country_All_CookIslands_154),
                    new Country(R.string.country_All_PitcairnIslands_155),
                    new Country(R.string.country_All_Pakistan_156),
                    new Country(R.string.country_All_Palau_157),
                    new Country(R.string.country_All_Palestine_158),
                    new Country(R.string.country_All_Panama_159),
                    new Country(R.string.country_All_PapuaNewGuinea_160),
                    new Country(R.string.country_All_Paraguay_161),
                    new Country(R.string.country_All_Peru_162),
                    new Country(R.string.country_All_Poland_163),
                    new Country(R.string.country_All_Portugal_164),
                    new Country(R.string.country_All_Transnistria_165),
                    new Country(R.string.country_All_PuertoRico_166),
                    new Country(R.string.country_All_Reunion_167),
                    new Country(R.string.country_All_RussianFederation_168),
                    new Country(R.string.country_All_Rwanda_169),
                    new Country(R.string.country_All_Romania_170),
                    new Country(R.string.country_All_Salvador_171),
                    new Country(R.string.country_All_EasternSamoa_172),
                    new Country(R.string.country_All_WesternSamoa_173),
                    new Country(R.string.country_All_SanMarino_174),
                    new Country(R.string.country_All_SaoTomeAndPrincipe_175),
                    new Country(R.string.country_All_SaudiArabia_176),
                    new Country(R.string.country_All_NorthernMarianaIslands_177),
                    new Country(R.string.country_All_Seychelles_178),
                    new Country(R.string.country_All_Senegal_179),
                    new Country(R.string.country_All_SaintPierreMiquelon_180),
                    new Country(R.string.country_All_SaintVincentАndTheGrenadines_181),
                    new Country(R.string.country_All_SaintChristopherSaintKittsAndNevis_182),
                    new Country(R.string.country_All_SaintLucia_183),
                    new Country(R.string.country_All_Serbia_184),
                    new Country(R.string.country_All_Singapore_185),
                    new Country(R.string.country_All_Syria_186),
                    new Country(R.string.country_All_Slovakia_187),
                    new Country(R.string.country_All_Slovenia_188),
                    new Country(R.string.country_All_USA_189),
                    new Country(R.string.country_All_SolomonIslands_190),
                    new Country(R.string.country_All_Somalia_191),
                    new Country(R.string.country_All_Somaliland_192),
                    new Country(R.string.country_All_Sudan_193),
                    new Country(R.string.country_All_Suriname_194),
                    new Country(R.string.country_All_SierraLeone_195),
                    new Country(R.string.country_All_Tajikistan_196),
                    new Country(R.string.country_All_Taiwan_197),
                    new Country(R.string.country_All_Thailand_198),
                    new Country(R.string.country_All_Tanzania_199),
                    new Country(R.string.country_All_TurksAndCaicos_200),
                    new Country(R.string.country_All_Togo_201),
                    new Country(R.string.country_All_Tokelau_202),
                    new Country(R.string.country_All_Tonga_203),
                    new Country(R.string.country_All_TrinidadAndTobago_204),
                    new Country(R.string.country_All_Tuvalu_205),
                    new Country(R.string.country_All_Tunisia_206),
                    new Country(R.string.country_All_Turkmenistan_207),
                    new Country(R.string.country_All_Turkey_208),
                    new Country(R.string.country_All_Uganda_209),
                    new Country(R.string.country_All_Uzbekistan_210),
                    new Country(R.string.country_All_Ukraine_211),
                    new Country(R.string.country_All_WallisAndFutuna_212),
                    new Country(R.string.country_All_Uruguay_213),
                    new Country(R.string.country_All_FaroeIslands_214),
                    new Country(R.string.country_All_FederatedStatesOfMicronesia_215),
                    new Country(R.string.country_All_Fiji_216),
                    new Country(R.string.country_All_Philippines_217),
                    new Country(R.string.country_All_Finland_218),
                    new Country(R.string.country_All_FalklandIslands_219),
                    new Country(R.string.country_All_France_220),
                    new Country(R.string.country_All_FrenchPolynesia_221),
                    new Country(R.string.country_All_Croatia_222),
                    new Country(R.string.country_All_CentralAfricanRepublic_223),
                    new Country(R.string.country_All_Chagos_224),
                    new Country(R.string.country_All_Chad_225),
                    new Country(R.string.country_All_Montenegro_226),
                    new Country(R.string.country_All_Czech_227),
                    new Country(R.string.country_All_Chile_228),
                    new Country(R.string.country_All_Svalbard_229),
                    new Country(R.string.country_All_Switzerland_230),
                    new Country(R.string.country_All_Sweden_231),
                    new Country(R.string.country_All_SriLanka_232),
                    new Country(R.string.country_All_Ecuador_233),
                    new Country(R.string.country_All_Eritrea_234),
                    new Country(R.string.country_All_Eswatini_235),
                    new Country(R.string.country_All_Estonia_236),
                    new Country(R.string.country_All_Ethiopia_237),
                    new Country(R.string.country_All_SouthOssetia_238),
                    new Country(R.string.country_All_RepublicOfSouthAfrica_239),
                    new Country(R.string.country_All_SouthSudan_240),
                    new Country(R.string.country_All_Jamaica_241),
                    new Country(R.string.country_All_Japan_242),
            };

    //Создаём переменную для индекса массива listC и инициализируем её через 0. По ней мы будем
// перебирать наш массив и выбирать страны. Также по этой переменной мы будем искать правильные
// столицы, так как порядковый номер Страны совпадает с порядковым номером подходящей
// для неё Столицы.
    private int ind_cou = 0;

    //Создаём список listA на основе класса Capital, из каталога model, из которого будем
// брать значения столиц
    private final Capital[] listA = new Capital[]
            {
                    new Capital(R.string.capital_All_Sukhumi_0),
                    new Capital(R.string.capital_All_Canberra_1),
                    new Capital(R.string.capital_All_Vein_2),
                    new Capital(R.string.capital_All_Baku_3),
                    new Capital(R.string.capital_All_PontaDelgada_4),
                    new Capital(R.string.capital_All_Mariehamn_5),
                    new Capital(R.string.capital_All_Tirana_6),
                    new Capital(R.string.capital_All_Algeria_7),
                    new Capital(R.string.capital_All_Valley_8),
                    new Capital(R.string.capital_All_Luanda_9),
                    new Capital(R.string.capital_All_AndorralaVella_10),
                    new Capital(R.string.capital_All_StJohns_11),
                    new Capital(R.string.capital_All_BuenosAires_12),
                    new Capital(R.string.capital_All_Yerevan_13),
                    new Capital(R.string.capital_All_Oranjestad_14),
                    new Capital(R.string.capital_All_Kabul_15),
                    new Capital(R.string.capital_All_Nassau_16),
                    new Capital(R.string.capital_All_Dhaka_17),
                    new Capital(R.string.capital_All_Bridgetown_18),
                    new Capital(R.string.capital_All_Manama_19),
                    new Capital(R.string.capital_All_Belmopan_20),
                    new Capital(R.string.capital_All_Minsk_21),
                    new Capital(R.string.capital_All_Brussels_22),
                    new Capital(R.string.capital_All_PortoNovo_23),
                    new Capital(R.string.capital_All_Hamilton_24),
                    new Capital(R.string.capital_All_Sofia_25),
                    new Capital(R.string.capital_All_LaPaz_26),
                    new Capital(R.string.capital_All_Kralendijk_27),
                    new Capital(R.string.capital_All_Sarajevo_28),
                    new Capital(R.string.capital_All_Gaborone_29),
                    new Capital(R.string.capital_All_Brasilia_30),
                    new Capital(R.string.capital_All_BandarSeriBegawan_31),
                    new Capital(R.string.capital_All_Ouagadougou_32),
                    new Capital(R.string.capital_All_Bujumbura_33),
                    new Capital(R.string.capital_All_Thimphu_34),
                    new Capital(R.string.capital_All_Vila_35),
                    new Capital(R.string.capital_All_Vatican_36),
                    new Capital(R.string.capital_All_London_37),
                    new Capital(R.string.capital_All_Budapest_38),
                    new Capital(R.string.capital_All_Caracas_39),
                    new Capital(R.string.capital_All_RoadTown_40),
                    new Capital(R.string.capital_All_CharlotteAmalie_41),
                    new Capital(R.string.capital_All_Dili_42),
                    new Capital(R.string.capital_All_Hanoi_43),
                    new Capital(R.string.capital_All_Libreville_44),
                    new Capital(R.string.capital_All_PortAuPrince_45),
                    new Capital(R.string.capital_All_Georgetown_46),
                    new Capital(R.string.capital_All_Banjul_47),
                    new Capital(R.string.capital_All_Accra_48),
                    new Capital(R.string.capital_All_BasTer_49),
                    new Capital(R.string.capital_All_Guatemala_50),
                    new Capital(R.string.capital_All_Cayenne_51),
                    new Capital(R.string.capital_All_Conakry_52),
                    new Capital(R.string.capital_All_Bissau_53),
                    new Capital(R.string.capital_All_Berlin_54),
                    new Capital(R.string.capital_All_SaintPeterPort_55),
                    new Capital(R.string.capital_All_Gibraltar_56),
                    new Capital(R.string.capital_All_Tegucigalpa_57),
                    new Capital(R.string.capital_All_HongKong_58),
                    new Capital(R.string.capital_All_StGeorges_59),
                    new Capital(R.string.capital_All_NuukGothob_60),
                    new Capital(R.string.capital_All_Athens_61),
                    new Capital(R.string.capital_All_Tbilisi_62),
                    new Capital(R.string.capital_All_Hagatna_63),
                    new Capital(R.string.capital_All_Malabo_64),
                    new Capital(R.string.capital_All_Copenhagen_65),
                    new Capital(R.string.capital_All_SaintHelier_66),
                    new Capital(R.string.capital_All_Djibouti_67),
                    new Capital(R.string.capital_All_Roseau_68),
                    new Capital(R.string.capital_All_SantoDomingo_69),
                    new Capital(R.string.capital_All_Cairo_70),
                    new Capital(R.string.capital_All_Lusaka_71),
                    new Capital(R.string.capital_All_Harare_72),
                    new Capital(R.string.capital_All_ElAaiunClaimedTifaritiActual_73),
                    new Capital(R.string.capital_All_Jerusalem_74),
                    new Capital(R.string.capital_All_NewDelhi_75),
                    new Capital(R.string.capital_All_Jakarta_76),
                    new Capital(R.string.capital_All_Amman_77),
                    new Capital(R.string.capital_All_Baghdad_78),
                    new Capital(R.string.capital_All_Tehran_79),
                    new Capital(R.string.capital_All_Dublin_80),
                    new Capital(R.string.capital_All_Reykjavik_81),
                    new Capital(R.string.capital_All_Madrid_82),
                    new Capital(R.string.capital_All_Rome_83),
                    new Capital(R.string.capital_All_Sana_84),
                    new Capital(R.string.capital_All_Praia_85),
                    new Capital(R.string.capital_All_NurSultanAstana_86),
                    new Capital(R.string.capital_All_PhnomPenh_87),
                    new Capital(R.string.capital_All_Yaounde_88),
                    new Capital(R.string.capital_All_Ottawa_89),
                    new Capital(R.string.capital_All_SantaCruzDeTenerifeOrLasPalmasDeGranCanaria_90),
                    new Capital(R.string.capital_All_Doha_91),
                    new Capital(R.string.capital_All_Nairobi_92),
                    new Capital(R.string.capital_All_Nicosia_93),
                    new Capital(R.string.capital_All_Lefkosia_94),
                    new Capital(R.string.capital_All_Bishkek_95),
                    new Capital(R.string.capital_All_Tarawa_96),
                    new Capital(R.string.capital_All_Beijing_97),
                    new Capital(R.string.capital_All_Bogota_98),
                    new Capital(R.string.capital_All_Moroni_99),
                    new Capital(R.string.capital_All_Brazzaville_100),
                    new Capital(R.string.capital_All_Kinshasa_101),
                    new Capital(R.string.capital_All_Pyongyang_102),
                    new Capital(R.string.capital_All_Seoul_103),
                    new Capital(R.string.capital_All_Pristina_104),
                    new Capital(R.string.capital_All_SanJose_105),
                    new Capital(R.string.capital_All_Yamoussoukro_106),
                    new Capital(R.string.capital_All_Havana_107),
                    new Capital(R.string.capital_All_ElKuwait_108),
                    new Capital(R.string.capital_All_Willemstad_109),
                    new Capital(R.string.capital_All_Vientiane_110),
                    new Capital(R.string.capital_All_Riga_111),
                    new Capital(R.string.capital_All_Maseru_112),
                    new Capital(R.string.capital_All_Monrovia_113),
                    new Capital(R.string.capital_All_Beirut_114),
                    new Capital(R.string.capital_All_Tripoli_115),
                    new Capital(R.string.capital_All_Vilnius_116),
                    new Capital(R.string.capital_All_Vaduz_117),
                    new Capital(R.string.capital_All_Luxembourg_118),
                    new Capital(R.string.capital_All_PortLouis_119),
                    new Capital(R.string.capital_All_Nouakchott_120),
                    new Capital(R.string.capital_All_Antananarivo_121),
                    new Capital(R.string.capital_All_Funchal_122),
                    new Capital(R.string.capital_All_Mamuzu_123),
                    new Capital(R.string.capital_All_Skopje_124),
                    new Capital(R.string.capital_All_Lilongwe_125),
                    new Capital(R.string.capital_All_KualaLumpur_126),
                    new Capital(R.string.capital_All_Bamako_127),
                    new Capital(R.string.capital_All_Male_128),
                    new Capital(R.string.capital_All_Valletta_129),
                    new Capital(R.string.capital_All_Rabat_130),
                    new Capital(R.string.capital_All_FortDeFrance_131),
                    new Capital(R.string.capital_All_Majuro_132),
                    new Capital(R.string.capital_All_MexicoCity_133),
                    new Capital(R.string.capital_All_Maputo_134),
                    new Capital(R.string.capital_All_Kishinev_135),
                    new Capital(R.string.capital_All_Monaco_136),
                    new Capital(R.string.capital_All_Ulaanbaatar_137),
                    new Capital(R.string.capital_All_PlymouthAndBradesA_138),
                    new Capital(R.string.capital_All_Naypyidaw_139),
                    new Capital(R.string.capital_All_Windhoek_140),
                    new Capital(R.string.capital_All_Yaren_141),
                    new Capital(R.string.capital_All_Kathmandu_142),
                    new Capital(R.string.capital_All_Niamey_143),
                    new Capital(R.string.capital_All_Abuja_144),
                    new Capital(R.string.capital_All_Amsterdam_145),
                    new Capital(R.string.capital_All_Managua_146),
                    new Capital(R.string.capital_All_Alofi_147),
                    new Capital(R.string.capital_All_Wellington_148),
                    new Capital(R.string.capital_All_Noumea_149),
                    new Capital(R.string.capital_All_Oslo_150),
                    new Capital(R.string.capital_All_AbuDhabi_151),
                    new Capital(R.string.capital_All_Muscat_152),
                    new Capital(R.string.capital_All_Georgetown_153),
                    new Capital(R.string.capital_All_Avarua_154),
                    new Capital(R.string.capital_All_Adamstown_155),
                    new Capital(R.string.capital_All_Islamabad_156),
                    new Capital(R.string.capital_All_Koror_157),
                    new Capital(R.string.capital_All_Ramallah_158),
                    new Capital(R.string.capital_All_Panama_159),
                    new Capital(R.string.capital_All_PortMoresby_160),
                    new Capital(R.string.capital_All_Asuncion_161),
                    new Capital(R.string.capital_All_Lima_162),
                    new Capital(R.string.capital_All_Warsaw_163),
                    new Capital(R.string.capital_All_Lisbon_164),
                    new Capital(R.string.capital_All_Tiraspol_165),
                    new Capital(R.string.capital_All_SanJuan_166),
                    new Capital(R.string.capital_All_SaintDenis_167),
                    new Capital(R.string.capital_All_Moscow_168),
                    new Capital(R.string.capital_All_Kigali_169),
                    new Capital(R.string.capital_All_Bucharest_170),
                    new Capital(R.string.capital_All_SanSalvador_171),
                    new Capital(R.string.capital_All_PagoPago_172),
                    new Capital(R.string.capital_All_Apia_173),
                    new Capital(R.string.capital_All_SanMarino_174),
                    new Capital(R.string.capital_All_SaoTome_175),
                    new Capital(R.string.capital_All_Riyadh_176),
                    new Capital(R.string.capital_All_Saipan_177),
                    new Capital(R.string.capital_All_Victoria_178),
                    new Capital(R.string.capital_All_Dakar_179),
                    new Capital(R.string.capital_All_SaintPierre_180),
                    new Capital(R.string.capital_All_Kingstown_181),
                    new Capital(R.string.capital_All_Buster_182),
                    new Capital(R.string.capital_All_Castries_183),
                    new Capital(R.string.capital_All_Belgrade_184),
                    new Capital(R.string.capital_All_Singapore_185),
                    new Capital(R.string.capital_All_Damascus_186),
                    new Capital(R.string.capital_All_Bratislava_187),
                    new Capital(R.string.capital_All_Ljubljana_188),
                    new Capital(R.string.capital_All_Washington_189),
                    new Capital(R.string.capital_All_Honiara_190),
                    new Capital(R.string.capital_All_Mogadishu_191),
                    new Capital(R.string.capital_All_Hargeisa_192),
                    new Capital(R.string.capital_All_Khartoum_193),
                    new Capital(R.string.capital_All_Paramaribo_194),
                    new Capital(R.string.capital_All_Freetown_195),
                    new Capital(R.string.capital_All_Dushanbe_196),
                    new Capital(R.string.capital_All_Taipei_197),
                    new Capital(R.string.capital_All_Bangkok_198),
                    new Capital(R.string.capital_All_Dodoma_199),
                    new Capital(R.string.capital_All_CockburnTown_200),
                    new Capital(R.string.capital_All_Lome_201),
                    new Capital(R.string.capital_All_Nukunonu_202),
                    new Capital(R.string.capital_All_Nukualofa_203),
                    new Capital(R.string.capital_All_PortOfSpain_204),
                    new Capital(R.string.capital_All_Funafuti_205),
                    new Capital(R.string.capital_All_Tunisia_206),
                    new Capital(R.string.capital_All_Ashgabat_207),
                    new Capital(R.string.capital_All_Ankara_208),
                    new Capital(R.string.capital_All_Kampala_209),
                    new Capital(R.string.capital_All_Tashkent_210),
                    new Capital(R.string.capital_All_Kyiv_211),
                    new Capital(R.string.capital_All_MataUtu_212),
                    new Capital(R.string.capital_All_Montevideo_213),
                    new Capital(R.string.capital_All_Torshavn_214),
                    new Capital(R.string.capital_All_Palikir_215),
                    new Capital(R.string.capital_All_Suva_216),
                    new Capital(R.string.capital_All_Manila_217),
                    new Capital(R.string.capital_All_Helsinki_218),
                    new Capital(R.string.capital_All_PortStanley_219),
                    new Capital(R.string.capital_All_Paris_220),
                    new Capital(R.string.capital_All_Papeete_221),
                    new Capital(R.string.capital_All_Zagreb_222),
                    new Capital(R.string.capital_All_Bangui_223),
                    new Capital(R.string.capital_All_DiegoGarcia_224),
                    new Capital(R.string.capital_All_Ndjamena_225),
                    new Capital(R.string.capital_All_Podgorica_226),
                    new Capital(R.string.capital_All_Prague_227),
                    new Capital(R.string.capital_All_Santiago_228),
                    new Capital(R.string.capital_All_Longyearbyen_229),
                    new Capital(R.string.capital_All_Berne_230),
                    new Capital(R.string.capital_All_Stockholm_231),
                    new Capital(R.string.capital_All_Colombo_232),
                    new Capital(R.string.capital_All_Quito_233),
                    new Capital(R.string.capital_All_Asmara_234),
                    new Capital(R.string.capital_All_Mbabane_235),
                    new Capital(R.string.capital_All_Tallinn_236),
                    new Capital(R.string.capital_All_AddisAbaba_237),
                    new Capital(R.string.capital_All_Tskhinvali_238),
                    new Capital(R.string.capital_All_Pretoria_239),
                    new Capital(R.string.capital_All_Juba_240),
                    new Capital(R.string.capital_All_kingston_241),
                    new Capital(R.string.capital_All_Tokyo_242),
            };

    @Override
//Метод onCreate(Bundle ...) вызывается при создании экземпляра субкласса активности.
// С него начинается показ активностей на экране, которые загружаются из разметки
// по указанному адресу - в данном случае -  R.layout.act_tren_100 (т.е. разметка
// расположена в папке res > layout > act_tren_NNN.xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tren_all);

//Подключаем виджет TextView, он задаёт текст из списка на позицию, где будет
// появляться очередная Столица
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listC[ind_cou].getCountryResId();
        rText.setText(question);

//Подключаем виджет TextView, он будет задавать текст результата ответа
        anCheck = (TextView) findViewById(R.id.answerCheck);
        anCheck.setText(R.string.wait_answer);

//Создаём переход на активность с результатом
        Intent intent = new Intent(this, Result_All.class);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
        int temp_1 = ind_cou;

        int temp_2 = random.nextInt(listA.length);
        while (temp_1 == temp_2) {
            temp_2 = random.nextInt(listA.length);
        }
        int temp_3 = random.nextInt(listA.length);
        while (temp_3 == temp_1 || temp_3 == temp_2) {
            temp_3 = random.nextInt(listA.length);
        }
        int temp_4 = random.nextInt(listA.length);
        while (temp_4 == temp_1 || temp_4 == temp_2 || temp_4 == temp_3) {
            temp_4 = random.nextInt(listA.length);
        }
//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
        int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
        int temp_i = random.nextInt(answer_capital.length);
//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
        int temp = answer_capital[temp_i];
//На место, выбранное генератором, переносим правильное значение столицы
        answer_capital[temp_i] = answer_capital[0];
//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
        answer_capital[0] = temp;

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_1, при этом удаляем
// их поля в act_tren_100.xml - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_1 = (Button) findViewById(R.id.but_1);
//Устанавливаем первоначальное значение для кнопки 1
        int cap1 = listA[answer_capital[0]].getCapitalResId();
        but_cap_1.setText(cap1);

//Подключаем переменные, для реакции на нажатие кнопки. Они расположены друг над другом.
// Следующие 4 поля нужны для вывода мотивирующей информации или подсказок, в случае ошибки
// (изначально в них отображались значения для отладки приложения).
        show_1 = (TextView) findViewById(R.id.show_1);
        show_2 = (TextView) findViewById(R.id.show_2);
        show_3 = (TextView) findViewById(R.id.show_3);
        show_4 = (TextView) findViewById(R.id.show_4);

//Сохраняем значения в переменные, потому что при клике по кнопке, в кнопке остаётся код,
// который становится "старым", т.е. он не обновляется одновременно с кодом в других кнопках.
// И при последующих проверках правильности выбора столицы это приводит к ошибке.
// Поэтому мы в самом начале кода кнопки загружаем в него новые значения, а на выходе из кода
// сохраняем в переменные, из которых потом загрузим во вновь нажатую кнопку. Наверное есть
// способ проще и лучше, но я пока его не знаю ;) Пища для рефакторинга и обновлений ;)
        num_1 = answer_capital[0];
        num_2 = answer_capital[1];
        num_3 = answer_capital[2];
        num_4 = answer_capital[3];

//Инициализируем счётчики правильных и неправильных ответов
        num_correct = 0;
        num_incorrect = 0;

//Подключаем виджеты полей @+id/num_correct and @+id/num_incorrect для вывода количества
// правильных и ошибочных ответов. При этом мы не можем просто вывести число int в поле TextView,
// для этого необходимо число преобразовать в текст методом
// String s = Integer.toString(преобразовываемое число);
        String numCorr = Integer.toString(num_correct);
        num_correct_t = (TextView) findViewById(R.id.num_correct);
        num_correct_t.setText(numCorr);

        String numInCorr = Integer.toString(num_incorrect);
        num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
        num_incorrect_t.setText(numInCorr);

//Первая кнопка с выбором столицы. Задаём значение виджету кнопки 1. Здесь мы реализуем интерфейс
// слушателя события. Собитие у нас - клик по кнопке. В круглых
// скобках "...stener(new View ... });" создаётся новый безымянный класс, который будет
// реализован вызываемым методом onClick. То есть после клика, запускается сразу несколько операций (проверка правильности, вывод результата.
// При этом первоначальный текст для Страны и 4 кнопок-Столиц уже задан, а после нажатия,
// происходит генерация новых значений для кнопок.

        but_cap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_1) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
                }

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 20.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_All.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
                int temp_1 = ind_cou;

                int temp_2 = random.nextInt(listA.length);
                while (temp_1 == temp_2) {
                    temp_2 = random.nextInt(listA.length);
                }
                int temp_3 = random.nextInt(listA.length);
                while (temp_3 == temp_1 || temp_3 == temp_2) {
                    temp_3 = random.nextInt(listA.length);
                }
                int temp_4 = random.nextInt(listA.length);
                while (temp_4 == temp_1 || temp_4 == temp_2 || temp_4 == temp_3) {
                    temp_4 = random.nextInt(listA.length);
                }

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_2, при этом удаляем
// их поля - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_2 = (Button) findViewById(R.id.but_2);
//Устанавливаем в неё первоначальное значение (до клика)
        int cap2 = listA[answer_capital[1]].getCapitalResId();
        but_cap_2.setText(cap2);

//Копируем содержимое первой кнопки с изменениями для 2 кнопки:
        but_cap_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_2) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
                }

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// !!! Возможно это потому, что мы передаём 1 intent, а не 2 разных intent. И второй переписывает
// первый. У нас же второй идёт за первым !!!
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из количества стран в списке!!!

// Сделать рефактор - чтобы вместо числа вопросов заданного вручную, устанавливалось число = длине массива!!!


                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_All.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
                int temp_1 = ind_cou;

                int temp_2 = random.nextInt(listA.length);
                while (temp_1 == temp_2) {
                    temp_2 = random.nextInt(listA.length);
                }
                int temp_3 = random.nextInt(listA.length);
                while (temp_3 == temp_1 || temp_3 == temp_2) {
                    temp_3 = random.nextInt(listA.length);
                }
                int temp_4 = random.nextInt(listA.length);
                while (temp_4 == temp_1 || temp_4 == temp_2 || temp_4 == temp_3) {
                    temp_4 = random.nextInt(listA.length);
                }

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_3, при этом удаляем
// их поля в activity_tren_100.xml - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_3 = (Button) findViewById(R.id.but_3);
//Устанавливаем в неё первоначальное значение (до клика)
        int cap3 = listA[answer_capital[2]].getCapitalResId();
        but_cap_3.setText(cap3);
//Копируем содержимое первой кнопки с изменениями для 3 кнопки:
        but_cap_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_3) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
                }

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 100.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_All.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
                int temp_1 = ind_cou;

                int temp_2 = random.nextInt(listA.length);
                while (temp_1 == temp_2) {
                    temp_2 = random.nextInt(listA.length);
                }
                int temp_3 = random.nextInt(listA.length);
                while (temp_3 == temp_1 || temp_3 == temp_2) {
                    temp_3 = random.nextInt(listA.length);
                }
                int temp_4 = random.nextInt(listA.length);
                while (temp_4 == temp_1 || temp_4 == temp_2 || temp_4 == temp_3) {
                    temp_4 = random.nextInt(listA.length);
                }

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_4, при этом удаляем
// их поля в activity_tren_20.xml - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_4 = (Button) findViewById(R.id.but_4);
        int cap4 = listA[answer_capital[3]].getCapitalResId();
//Устанавливаем в неё первоначальное значение (до клика)
        but_cap_4.setText(cap4);
//Копируем содержимое первой кнопки с изменениями для 4 кнопки:
        but_cap_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_4) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
                }

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 20.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_All.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
                int temp_1 = ind_cou;

                int temp_2 = random.nextInt(listA.length);
                while (temp_1 == temp_2) {
                    temp_2 = random.nextInt(listA.length);
                }
                int temp_3 = random.nextInt(listA.length);
                while (temp_3 == temp_1 || temp_3 == temp_2) {
                    temp_3 = random.nextInt(listA.length);
                }
                int temp_4 = random.nextInt(listA.length);
                while (temp_4 == temp_1 || temp_4 == temp_2 || temp_4 == temp_3) {
                    temp_4 = random.nextInt(listA.length);
                }

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });
    }
    //Кнопка перехода к базе стран-столиц
    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }
    //Кнопка перехода к Подсказке
    public void goToPrompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }
    //Кнопка перехода к Списку тренировок
    public void goToListTren (View v){
        Intent intent = new Intent(this, ListTren.class);
        startActivity(intent);
    }
}