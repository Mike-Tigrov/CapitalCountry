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

public class Tren_OON extends AppCompatActivity {

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
    int num_questions = 191;

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
    private Country[] listC = new Country[]
            {
                    new Country(R.string.country_OON_Australia_0),
                    new Country(R.string.country_OON_Austria_1),
                    new Country(R.string.country_OON_Azerbaijan_2),
                    new Country(R.string.country_OON_Albania_3),
                    new Country(R.string.country_OON_Algeria_4),
                    new Country(R.string.country_OON_Angola_5),
                    new Country(R.string.country_OON_Andorra_6),
                    new Country(R.string.country_OON_AntiguaAndBarbuda_7),
                    new Country(R.string.country_OON_Argentina_8),
                    new Country(R.string.country_OON_Armenia_9),
                    new Country(R.string.country_OON_Afghanistan_10),
                    new Country(R.string.country_OON_Bahamas_11),
                    new Country(R.string.country_OON_Bangladesh_12),
                    new Country(R.string.country_OON_Barbados_13),
                    new Country(R.string.country_OON_Bahrain_14),
                    new Country(R.string.country_OON_Belize_15),
                    new Country(R.string.country_OON_Belarus_16),
                    new Country(R.string.country_OON_Belgium_17),
                    new Country(R.string.country_OON_Benin_18),
                    new Country(R.string.country_OON_Bulgaria_19),
                    new Country(R.string.country_OON_Bolivia_20),
                    new Country(R.string.country_OON_BosniaAndHerzegovina_21),
                    new Country(R.string.country_OON_Botswana_22),
                    new Country(R.string.country_OON_Brazil_23),
                    new Country(R.string.country_OON_Brunei_24),
                    new Country(R.string.country_OON_BurkinaFaso_25),
                    new Country(R.string.country_OON_Burundi_26),
                    new Country(R.string.country_OON_Butane_27),
                    new Country(R.string.country_OON_Vanuatu_28),
                    new Country(R.string.country_OON_GreatBritain_29),
                    new Country(R.string.country_OON_Hungary_30),
                    new Country(R.string.country_OON_Venezuela_31),
                    new Country(R.string.country_OON_EastTimor_32),
                    new Country(R.string.country_OON_Vietnam_33),
                    new Country(R.string.country_OON_Gabon_34),
                    new Country(R.string.country_OON_Haiti_35),
                    new Country(R.string.country_OON_Guyana_36),
                    new Country(R.string.country_OON_Gambia_37),
                    new Country(R.string.country_OON_Ghana_38),
                    new Country(R.string.country_OON_Guatemala_39),
                    new Country(R.string.country_OON_Guinea_40),
                    new Country(R.string.country_OON_GuineaBissau_41),
                    new Country(R.string.country_OON_Germany_42),
                    new Country(R.string.country_OON_Honduras_43),
                    new Country(R.string.country_OON_Grenada_44),
                    new Country(R.string.country_OON_Greece_45),
                    new Country(R.string.country_OON_Georgia_46),
                    new Country(R.string.country_OON_Denmark_47),
                    new Country(R.string.country_OON_DemocraticRepublicOfTheCongoFormerZaire_48),
                    new Country(R.string.country_OON_Djibouti_49),
                    new Country(R.string.country_OON_Dominica_50),
                    new Country(R.string.country_OON_DominicanRepublic_51),
                    new Country(R.string.country_OON_Egypt_52),
                    new Country(R.string.country_OON_Zambia_53),
                    new Country(R.string.country_OON_WesternSamoa_54),
                    new Country(R.string.country_OON_Zimbabwe_55),
                    new Country(R.string.country_OON_Yemen_56),
                    new Country(R.string.country_OON_Israel_57),
                    new Country(R.string.country_OON_India_58),
                    new Country(R.string.country_OON_Indonesia_59),
                    new Country(R.string.country_OON_Jordan_60),
                    new Country(R.string.country_OON_Iraq_61),
                    new Country(R.string.country_OON_Iran_62),
                    new Country(R.string.country_OON_Ireland_63),
                    new Country(R.string.country_OON_Iceland_64),
                    new Country(R.string.country_OON_Spain_65),
                    new Country(R.string.country_OON_Italy_66),
                    new Country(R.string.country_OON_CapeVerde_67),
                    new Country(R.string.country_OON_Kazakhstan_68),
                    new Country(R.string.country_OON_Cambodia_69),
                    new Country(R.string.country_OON_Cameroon_70),
                    new Country(R.string.country_OON_Canada_71),
                    new Country(R.string.country_OON_Qatar_72),
                    new Country(R.string.country_OON_Kenya_73),
                    new Country(R.string.country_OON_Cyprus_74),
                    new Country(R.string.country_OON_Kyrgyzstan_75),
                    new Country(R.string.country_OON_Kiribati_76),
                    new Country(R.string.country_OON_China_77),
                    new Country(R.string.country_OON_Colombia_78),
                    new Country(R.string.country_OON_Comoros_79),
                    new Country(R.string.country_OON_Congo_80),
                    new Country(R.string.country_OON_KoreaNorth_81),
                    new Country(R.string.country_OON_SouthKorea_82),
                    new Country(R.string.country_OON_CostaRica_83),
                    new Country(R.string.country_OON_IvoryCoast_84),
                    new Country(R.string.country_OON_Cuba_85),
                    new Country(R.string.country_OON_Kuwait_86),
                    new Country(R.string.country_OON_Laos_87),
                    new Country(R.string.country_OON_Latvia_88),
                    new Country(R.string.country_OON_Lesotho_89),
                    new Country(R.string.country_OON_Liberia_90),
                    new Country(R.string.country_OON_Lebanon_91),
                    new Country(R.string.country_OON_Libya_92),
                    new Country(R.string.country_OON_Lithuania_93),
                    new Country(R.string.country_OON_Liechtenstein_94),
                    new Country(R.string.country_OON_Luxembourg_95),
                    new Country(R.string.country_OON_Mauritius_96),
                    new Country(R.string.country_OON_Mauritania_97),
                    new Country(R.string.country_OON_Madagascar_98),
                    new Country(R.string.country_OON_Malawi_99),
                    new Country(R.string.country_OON_Malaysia_100),
                    new Country(R.string.country_OON_Mali_101),
                    new Country(R.string.country_OON_Maldives_102),
                    new Country(R.string.country_OON_Malta_103),
                    new Country(R.string.country_OON_Morocco_104),
                    new Country(R.string.country_OON_MarshallIslands_105),
                    new Country(R.string.country_OON_Mexico_106),
                    new Country(R.string.country_OON_Mozambique_107),
                    new Country(R.string.country_OON_Moldova_108),
                    new Country(R.string.country_OON_Monaco_109),
                    new Country(R.string.country_OON_Mongolia_110),
                    new Country(R.string.country_OON_Myanmar_111),
                    new Country(R.string.country_OON_Namibia_112),
                    new Country(R.string.country_OON_Nauru_113),
                    new Country(R.string.country_OON_Nepal_114),
                    new Country(R.string.country_OON_Niger_115),
                    new Country(R.string.country_OON_Nigeria_116),
                    new Country(R.string.country_OON_Netherlands_117),
                    new Country(R.string.country_OON_Nicaragua_118),
                    new Country(R.string.country_OON_NewZealand_119),
                    new Country(R.string.country_OON_Norway_120),
                    new Country(R.string.country_OON_UnitedArabEmiratesUAE_121),
                    new Country(R.string.country_OON_Oman_122),
                    new Country(R.string.country_OON_Pakistan_123),
                    new Country(R.string.country_OON_Palau_124),
                    new Country(R.string.country_OON_Panama_125),
                    new Country(R.string.country_OON_PapuaNewGuinea_126),
                    new Country(R.string.country_OON_Paraguay_127),
                    new Country(R.string.country_OON_Peru_128),
                    new Country(R.string.country_OON_Poland_129),
                    new Country(R.string.country_OON_Portugal_130),
                    new Country(R.string.country_OON_RussianFederation_131),
                    new Country(R.string.country_OON_Rwanda_132),
                    new Country(R.string.country_OON_Romania_133),
                    new Country(R.string.country_OON_Salvador_134),
                    new Country(R.string.country_OON_SanMarino_135),
                    new Country(R.string.country_OON_SaoTomeAndPrincipe_136),
                    new Country(R.string.country_OON_SaudiArabia_137),
                    new Country(R.string.country_OON_NorthMacedonia_138),
                    new Country(R.string.country_OON_Seychelles_139),
                    new Country(R.string.country_OON_Senegal_140),
                    new Country(R.string.country_OON_SaintVincentAndTheGrenadines_141),
                    new Country(R.string.country_OON_SaintChristopher_142),
                    new Country(R.string.country_OON_SaintLucia_143),
                    new Country(R.string.country_OON_Serbia_144),
                    new Country(R.string.country_OON_Singapore_145),
                    new Country(R.string.country_OON_Syria_146),
                    new Country(R.string.country_OON_Slovakia_147),
                    new Country(R.string.country_OON_Slovenia_148),
                    new Country(R.string.country_OON_USA_149),
                    new Country(R.string.country_OON_SolomonIslands_150),
                    new Country(R.string.country_OON_Somalia_151),
                    new Country(R.string.country_OON_Sudan_152),
                    new Country(R.string.country_OON_Suriname_153),
                    new Country(R.string.country_OON_SierraLeone_154),
                    new Country(R.string.country_OON_Tajikistan_155),
                    new Country(R.string.country_OON_Thailand_156),
                    new Country(R.string.country_OON_Tanzania_157),
                    new Country(R.string.country_OON_Togo_158),
                    new Country(R.string.country_OON_Tonga_159),
                    new Country(R.string.country_OON_TrinidadAndTobago_160),
                    new Country(R.string.country_OON_Tuvalu_161),
                    new Country(R.string.country_OON_Tunisia_162),
                    new Country(R.string.country_OON_Turkmenistan_163),
                    new Country(R.string.country_OON_TURKHINA_164),
                    new Country(R.string.country_OON_Uganda_165),
                    new Country(R.string.country_OON_Uzbekistan_166),
                    new Country(R.string.country_OON_Ukraine_167),
                    new Country(R.string.country_OON_Uruguay_168),
                    new Country(R.string.country_OON_FederatedExpectationsOfMicronesia_169),
                    new Country(R.string.country_OON_Fiji_170),
                    new Country(R.string.country_OON_Philippines_171),
                    new Country(R.string.country_OON_Finland_172),
                    new Country(R.string.country_OON_France_173),
                    new Country(R.string.country_OON_Croatia_174),
                    new Country(R.string.country_OON_CentralAfricanRepublic_175),
                    new Country(R.string.country_OON_Chad_176),
                    new Country(R.string.country_OON_Montenegro_177),
                    new Country(R.string.country_OON_Czech_178),
                    new Country(R.string.country_OON_Chile_179),
                    new Country(R.string.country_OON_Switzerland_180),
                    new Country(R.string.country_OON_Sweden_181),
                    new Country(R.string.country_OON_SriLanka_182),
                    new Country(R.string.country_OON_Ecuador_183),
                    new Country(R.string.country_OON_EquatorialGuinea_184),
                    new Country(R.string.country_OON_Eritrea_185),
                    new Country(R.string.country_OON_Eswatini_186),
                    new Country(R.string.country_OON_Estonia_187),
                    new Country(R.string.country_OON_Ethiopia_188),
                    new Country(R.string.country_OON_RepublicOfSouthAfrica_189),
                    new Country(R.string.country_OON_SouthSudan_190),
                    new Country(R.string.country_OON_Jamaica_191),
                    new Country(R.string.country_OON_Japan_192),
            };

    //Создаём переменную для индекса массива listC и инициализируем её через 0. По ней мы будем
// перебирать наш массив и выбирать страны. Также по этой переменной мы будем искать правильные
// столицы, так как порядковый номер Страны совпадает с порядковым номером подходящей
// для неё Столицы.
    private int ind_cou = 0;

    //Создаём список listA на основе класса Capital, из каталога model, из которого будем
// брать значения столиц
    private Capital[] listA = new Capital[]
            {
                    new Capital(R.string.capital_OON_Canberra_0),
                    new Capital(R.string.capital_OON_Vein_1),
                    new Capital(R.string.capital_OON_Baku_2),
                    new Capital(R.string.capital_OON_Tirana_3),
                    new Capital(R.string.capital_OON_Algeria_4),
                    new Capital(R.string.capital_OON_Luanda_5),
                    new Capital(R.string.capital_OON_AndorralaVella_6),
                    new Capital(R.string.capital_OON_StJohns_7),
                    new Capital(R.string.capital_OON_BuenosAires_8),
                    new Capital(R.string.capital_OON_Yerevan_9),
                    new Capital(R.string.capital_OON_Kabul_10),
                    new Capital(R.string.capital_OON_Nassau_11),
                    new Capital(R.string.capital_OON_Dhaka_12),
                    new Capital(R.string.capital_OON_Bridgetown_13),
                    new Capital(R.string.capital_OON_Manama_14),
                    new Capital(R.string.capital_OON_Belmopan_15),
                    new Capital(R.string.capital_OON_Minsk_16),
                    new Capital(R.string.capital_OON_Brussels_17),
                    new Capital(R.string.capital_OON_PortoNovo_18),
                    new Capital(R.string.capital_OON_Sofia_19),
                    new Capital(R.string.capital_OON_LaPaz_20),
                    new Capital(R.string.capital_OON_Sarajevo_21),
                    new Capital(R.string.capital_OON_Gaborone_22),
                    new Capital(R.string.capital_OON_Brasilia_23),
                    new Capital(R.string.capital_OON_BandarSeriBegawan_24),
                    new Capital(R.string.capital_OON_Ouagadougou_25),
                    new Capital(R.string.capital_OON_Bujumbura_26),
                    new Capital(R.string.capital_OON_Thimphu_27),
                    new Capital(R.string.capital_OON_vila_28),
                    new Capital(R.string.capital_OON_London_29),
                    new Capital(R.string.capital_OON_Budapest_30),
                    new Capital(R.string.capital_OON_Caracas_31),
                    new Capital(R.string.capital_OON_Dili_32),
                    new Capital(R.string.capital_OON_Hanoi_33),
                    new Capital(R.string.capital_OON_Libreville_34),
                    new Capital(R.string.capital_OON_Georgetown_35),
                    new Capital(R.string.capital_OON_PortAuPrince_36),
                    new Capital(R.string.capital_OON_Banjul_37),
                    new Capital(R.string.capital_OON_Accra_38),
                    new Capital(R.string.capital_OON_Guatemala_39),
                    new Capital(R.string.capital_OON_Conakry_40),
                    new Capital(R.string.capital_OON_Bissau_41),
                    new Capital(R.string.capital_OON_Berlin_42),
                    new Capital(R.string.capital_OON_Tegucigalpa_43),
                    new Capital(R.string.capital_OON_StGeorges_44),
                    new Capital(R.string.capital_OON_Athens_45),
                    new Capital(R.string.capital_OON_Tbilisi_46),
                    new Capital(R.string.capital_OON_Copenhagen_47),
                    new Capital(R.string.capital_OON_Kinshasa_48),
                    new Capital(R.string.capital_OON_Djibouti_49),
                    new Capital(R.string.capital_OON_Roseau_50),
                    new Capital(R.string.capital_OON_SantoDomingo_51),
                    new Capital(R.string.capital_OON_Cairo_52),
                    new Capital(R.string.capital_OON_Lusaka_53),
                    new Capital(R.string.capital_OON_Apia_54),
                    new Capital(R.string.capital_OON_Harare_55),
                    new Capital(R.string.capital_OON_Sana_56),
                    new Capital(R.string.capital_OON_Jerusalem_57),
                    new Capital(R.string.capital_OON_NewDelhi_58),
                    new Capital(R.string.capital_OON_Jakarta_59),
                    new Capital(R.string.capital_OON_Amman_60),
                    new Capital(R.string.capital_OON_Baghdad_61),
                    new Capital(R.string.capital_OON_Tehran_62),
                    new Capital(R.string.capital_OON_Dublin_63),
                    new Capital(R.string.capital_OON_Reykjavik_64),
                    new Capital(R.string.capital_OON_Madrid_65),
                    new Capital(R.string.capital_OON_Rome_66),
                    new Capital(R.string.capital_OON_Praia_67),
                    new Capital(R.string.capital_OON_NurSultaAstana_68),
                    new Capital(R.string.capital_OON_PhnomPenh_69),
                    new Capital(R.string.capital_OON_Yaounde_70),
                    new Capital(R.string.capital_OON_Ottawa_71),
                    new Capital(R.string.capital_OON_Doha_72),
                    new Capital(R.string.capital_OON_Nairobi_73),
                    new Capital(R.string.capital_OON_Nicosia_74),
                    new Capital(R.string.capital_OON_Bishkek_75),
                    new Capital(R.string.capital_OON_Tarawa_76),
                    new Capital(R.string.capital_OON_Beijing_77),
                    new Capital(R.string.capital_OON_Bogota_78),
                    new Capital(R.string.capital_OON_Moroni_79),
                    new Capital(R.string.capital_OON_Brazzaville_80),
                    new Capital(R.string.capital_OON_Pyongyang_81),
                    new Capital(R.string.capital_OON_Seoul_82),
                    new Capital(R.string.capital_OON_SanJose_83),
                    new Capital(R.string.capital_OON_Yamoussoukro_84),
                    new Capital(R.string.capital_OON_Havana_85),
                    new Capital(R.string.capital_OON_ElKuwait_86),
                    new Capital(R.string.capital_OON_Vientiane_87),
                    new Capital(R.string.capital_OON_Riga_88),
                    new Capital(R.string.capital_OON_Maseru_89),
                    new Capital(R.string.capital_OON_Monrovia_90),
                    new Capital(R.string.capital_OON_Beirut_91),
                    new Capital(R.string.capital_OON_Tripoli_92),
                    new Capital(R.string.capital_OON_Vilnius_93),
                    new Capital(R.string.capital_OON_Vaduz_94),
                    new Capital(R.string.capital_OON_Luxembourg_95),
                    new Capital(R.string.capital_OON_PortLouis_96),
                    new Capital(R.string.capital_OON_Nouakchott_97),
                    new Capital(R.string.capital_OON_Antananarivo_98),
                    new Capital(R.string.capital_OON_Lilongwe_99),
                    new Capital(R.string.capital_OON_KualaLumpur_100),
                    new Capital(R.string.capital_OON_Bamako_101),
                    new Capital(R.string.capital_OON_Male_102),
                    new Capital(R.string.capital_OON_Valletta_103),
                    new Capital(R.string.capital_OON_Rabat_104),
                    new Capital(R.string.capital_OON_Majuro_105),
                    new Capital(R.string.capital_OON_MexicoCity_106),
                    new Capital(R.string.capital_OON_Maputo_107),
                    new Capital(R.string.capital_OON_Kishinev_108),
                    new Capital(R.string.capital_OON_Monaco_109),
                    new Capital(R.string.capital_OON_Ulaanbaatar_110),
                    new Capital(R.string.capital_OON_Naypyidaw_111),
                    new Capital(R.string.capital_OON_Windhoek_112),
                    new Capital(R.string.capital_OON_Yaren_113),
                    new Capital(R.string.capital_OON_Kathmandu_114),
                    new Capital(R.string.capital_OON_Niamey_115),
                    new Capital(R.string.capital_OON_Abuja_116),
                    new Capital(R.string.capital_OON_Amsterdam_117),
                    new Capital(R.string.capital_OON_Managua_118),
                    new Capital(R.string.capital_OON_Wellington_119),
                    new Capital(R.string.capital_OON_Oslo_120),
                    new Capital(R.string.capital_OON_AbuDhabi_121),
                    new Capital(R.string.capital_OON_Muscat_122),
                    new Capital(R.string.capital_OON_Islamabad_123),
                    new Capital(R.string.capital_OON_Koror_124),
                    new Capital(R.string.capital_OON_Panama_125),
                    new Capital(R.string.capital_OON_PortMoresby_126),
                    new Capital(R.string.capital_OON_Asuncion_127),
                    new Capital(R.string.capital_OON_Lima_128),
                    new Capital(R.string.capital_OON_Warsaw_129),
                    new Capital(R.string.capital_OON_Lisbon_130),
                    new Capital(R.string.capital_OON_Moscow_131),
                    new Capital(R.string.capital_OON_Kigali_132),
                    new Capital(R.string.capital_OON_Bucharest_133),
                    new Capital(R.string.capital_OON_SanSalvador_134),
                    new Capital(R.string.capital_OON_SanMarino_135),
                    new Capital(R.string.capital_OON_SaoTome_136),
                    new Capital(R.string.capital_OON_Riyadh_137),
                    new Capital(R.string.capital_OON_Skopje_138),
                    new Capital(R.string.capital_OON_Victoria_139),
                    new Capital(R.string.capital_OON_Dakar_140),
                    new Capital(R.string.capital_OON_Kingstown_141),
                    new Capital(R.string.capital_OON_Buster_142),
                    new Capital(R.string.capital_OON_Castries_143),
                    new Capital(R.string.capital_OON_Belgrade_144),
                    new Capital(R.string.capital_OON_Singapore_145),
                    new Capital(R.string.capital_OON_Damascus_146),
                    new Capital(R.string.capital_OON_Bratislava_147),
                    new Capital(R.string.capital_OON_Ljubljana_148),
                    new Capital(R.string.capital_OON_Washington_149),
                    new Capital(R.string.capital_OON_Honiara_150),
                    new Capital(R.string.capital_OON_Mogadishu_151),
                    new Capital(R.string.capital_OON_Khartoum_152),
                    new Capital(R.string.capital_OON_Paramaribo_153),
                    new Capital(R.string.capital_OON_Freetown_154),
                    new Capital(R.string.capital_OON_Dushanbe_155),
                    new Capital(R.string.capital_OON_Bangkok_156),
                    new Capital(R.string.capital_OON_Dodoma_157),
                    new Capital(R.string.capital_OON_Lome_158),
                    new Capital(R.string.capital_OON_Nukualofa_159),
                    new Capital(R.string.capital_OON_PortOfSpain_160),
                    new Capital(R.string.capital_OON_Funafuti_161),
                    new Capital(R.string.capital_OON_Tunisia_162),
                    new Capital(R.string.capital_OON_Ashgabat_163),
                    new Capital(R.string.capital_OON_Ankara_164),
                    new Capital(R.string.capital_OON_Kampala_165),
                    new Capital(R.string.capital_OON_Tashkent_166),
                    new Capital(R.string.capital_OON_Kyiv_167),
                    new Capital(R.string.capital_OON_Montevideo_168),
                    new Capital(R.string.capital_OON_Palikir_169),
                    new Capital(R.string.capital_OON_Suva_170),
                    new Capital(R.string.capital_OON_Manila_171),
                    new Capital(R.string.capital_OON_Helsinki_172),
                    new Capital(R.string.capital_OON_Paris_173),
                    new Capital(R.string.capital_OON_Zagreb_174),
                    new Capital(R.string.capital_OON_Bangui_175),
                    new Capital(R.string.capital_OON_Ndjamena_176),
                    new Capital(R.string.capital_OON_Podgorica_177),
                    new Capital(R.string.capital_OON_Prague_178),
                    new Capital(R.string.capital_OON_Santiago_179),
                    new Capital(R.string.capital_OON_Berne_180),
                    new Capital(R.string.capital_OON_Stockholm_181),
                    new Capital(R.string.capital_OON_Colombo_182),
                    new Capital(R.string.capital_OON_Quito_183),
                    new Capital(R.string.capital_OON_Malabo_184),
                    new Capital(R.string.capital_OON_Asmara_185),
                    new Capital(R.string.capital_OON_Mbabane_186),
                    new Capital(R.string.capital_OON_Tallinn_187),
                    new Capital(R.string.capital_OON_AddisAbaba_188),
                    new Capital(R.string.capital_OON_Pretoria_189),
                    new Capital(R.string.capital_OON_Juba_190),
                    new Capital(R.string.capital_OON_Kingston_191),
                    new Capital(R.string.capital_OON_Tokyo_192),
            };

    @Override
//Метод onCreate(Bundle ...) вызывается при создании экземпляра субкласса активности.
// С него начинается показ активностей на экране, которые загружаются из разметки
// по указанному адресу - в данном случае -  R.layout.act_tren_100 (т.е. разметка
// расположена в папке res > layout > act_tren_100.xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tren_oon);

//Подключаем виджет TextView, он задаёт текст из списка на позицию, где будет
// появляться очередная Столица
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listC[ind_cou].getCountryResId();
        rText.setText(question);

//Подключаем виджет TextView, он будет задавать текст результата ответа
        anCheck = (TextView) findViewById(R.id.answerCheck);
        anCheck.setText(R.string.wait_answer);

//Создаём переход на активность с результатом
        Intent intent = new Intent(this, Result_OON.class);

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
                    intent.putExtra(Result_OON.num_correct_result, cor);
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
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 20.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_OON.num_correct_result, cor);
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
                    intent.putExtra(Result_OON.num_correct_result, cor);
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
                    intent.putExtra(Result_OON.num_correct_result, cor);
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