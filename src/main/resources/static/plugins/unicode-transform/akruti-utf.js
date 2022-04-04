function akrutiUTFConvert($data) {
    var array_one = new Array(

        "1", "१",
        "2", "२",
        "3", "३",
        "4", "४",
        "5", "५",
        "6", "६",
        "7", "७",
        "8", "८",
        "9", "९",
        "0", "०",

        "ß", "ॐ", //

        " ̒", "'",
        " ̓", "'",
        "`", "'",
        "e̓s", "े'",
        "•", "ड्ड",
        "ñe", "mj",
        "Ô", "ह्",
        "ea", "ीÃ",
        "›", "ड़",
        "!̓", "!'",
        "¦", "्रु",

        "?̓", "?'",
        "õ", "–", //

        "C³ex", "र्ण्ये",
        "C³eex", "र्ण्यो",
        "DeeW ", "ओं",
        "eex", "eesÃ",
        "ex", "esÃ",
        "x", "ेÃ",
        "eez", "eewÃ",
        "ez", "ewÃ",
        "z", "ौÃ",
        "z", "ौÃ",

        "Ne", "र",
        "N", "र्",
        "Öe", "प्र",
        "Ö", "प्र्",
        //"eE","ंि",
        "eE", "ß",
        "²", "ङ्ग",
        "§", "ु",
        "$eÝ", "ऋ",


        "^", "्र",
        "±", "ङ्ख",
        "¨e", "द्म",
        "¨", "द्म",
        "¿e", "ह्य",
        "eÅ", "bि",
        "eA", "ीÃb",

        "dÀ", "Àd",
        "bÀ", "Àb",
        "gÀ", "Àg",
        "tÀ", "Àt",
        "sÀ", "Às",
        "wÀ", "Àw",
        "BÀ", "ÀB",
        "=À", "À=",

        "Ü", "द्व",
        "eEkeÀ", "किं",
        "E", "प्",
        "½e", "श्च",
        "»", "ह्व",
        "×", "द्ध",
        "îe", "्य",
        "Úe", "ह्न",
        "Ú", "ह्न",
        "Je", "व",
        "J", "व्",
        "ÿ", "ष्ठ",
        "¢", "दृ",
        "³e", "य",
        "#e", "क्ष",
        "#", "क्ष्",
        "¹", "ङ्क",
        "¼", "ह्ल",
        "¡e", "ञ्ज",
        "%e", "ज्ञ",
        "%", "ज्ञ्",
        "ö", "-",
        "Q", "ैं",
        //"”","ह्ण",
        "ñ", "स्र",
        "Â", "द्ब",
        "æ", "़",
        "Ó", "द्भ",
        "F&", "ई",
        "Ss", "ऐ",
        "Deew", "औ",
        "keÀ", "क",
        "Dees", "ओ",
        "#e", "क्ष",
        "$eÀ", "क्र",
        "$e", "त्र",
        "ïe", "ह्म",
        "¿e", "ह्य",
        "er", "ी",
        "Ke", "ख",
        "K", "ख्",
        "ðe", "स्त्र",
        "ûe", "ग्र",
        "û", "ग्",
        "ÊeÀ", "क्त",
        "Êe", "त्त",
        "Ê", "त्त्",
        "&À", "À&",
        "Æ", "ट्ट",
        "Ve", "न्न",
        "V", "न्न्", //
        "Òe", "प्र",
        "Ò", "प्र",
        "Î", "द्द",
        "eq", "ि",
        "~", "।",
        "ie²", "ङ्ग",
        "²e", "ङ",
        "²", "ङ्ग",
        "ª", "रू",
        "Í", "श्",
        "}", "ल",
        "ä", "ष्ट",
        "==", "ॄ",
        "=", "ृ",
        //"Ü","त्र",
        "Þe", "श्र",
        //"Þ","श्र",
        "ée", "श्व",
        "©", "रु",
        "áe", "ञ्च",
        "ç", "ऽ",
        "Ç", "ठ्ठ", // custom line
        "HeÀ", "फ",
        "$", "ledjd",
        "B", "ँ",

        "bb", "ं",
        "b", "ं",
        "eR", "ीं",
        "ë", "ः",
        "F", "इ",
        "G", "उ",
        "T", "ऊ",
        "keÌ", "क्",
        "¬eÀ", "क्र",
        "¸", "ख्र",
        "ie", "ग",
        "i", "ग्",
        "Ie", "घ",
        "I", "घ्",
        "*", "ङ",
        "®e", "च",
        "®", "च्",
        "í", "छ",
        "pe", "ज",
        "p", "ज्",
        "ý", "ज्र",
        "Pe", "झ",
        "â", "झ्र",
        "_e", "ञ",
        "ì", "ट",
        "þ", "ठ",
        "[", "ड", //there is clash between these two. Can't be resolved. All [ must be checked finally for probable ड
        "{", "ढ",
        "Ce", "ण",
        "C", "ण्",
        "le", "त",
        "Le", "थ",
        "L", "थ्",
        "o", "द",
        "Ðe", "द्य",
        "ê", "द्र",
        "Oe", "ध",
        "O", "ध्",
        "ve", "न",
        "v", "न्",
        "He", "प",
        "he", "प",
        "H", "प्",
        "ÖeÀ", "फ्र",
        "ye", "ब",
        "Ye", "भ",
        "ce", "म",
        "y", "ब्",
        "Y", "भ्",
        "c", "म्",
        "j", "र",
        "e´", "्र",
        "´e", "्र",
        "´", "्र",
        "ue", "ल",
        "u", "ल्",
        "U", "ळ", // Custom line
        "Me", "श",
        "M", "श्",
        "<e", "ष",
        "<", "ष्",
        "&lt;e", "ष", // Custom line
        "&lt;", "ष्", // Custom line
        "me", "स",
        "m", "स्",
        "n", "ह",
        "Ë", "हृ",
        "Ú", "ह्न",
        "Û", "ह्र",
        "ew", "ौ",
        "eW", "ों",
        "W", "ें",
        "g", "ु",
        "t", "ू",
        "ess", "ो",
        "es", "ो",
        "ss", "े",
        "s", "े",
        "ww", "ै",
        "w", "ै",
        "dd", "्",
        "d", "्",
        "ef", "ि",
        "$eÝ", "ऋ",
        "S", "ए",
        "keÀ", "क",
        "Dee", "आ",
        "De", "अ",
        "ke", "व",
        "ees", "ो",
        "e", "ा",
        "_", "ञ्",

        "³", "य्",


        "l", "त्"

    )

    //**********************************************
    //variables are set here. array_one_length is the variable and its value is array_one.length

    //The value property sets or returns the value of the value attribute of a text field.
    //The value property contains the default value OR the value a user types in (or a value set by a script).

    var array_one_length = array_one.length;

    var modified_substring = $data;

    //document.getElementById("unicode_text").value = "Conversion in progress..";


    //****************************************************
    //  Break the long text into small bunches of chunk_size  characters each.
    //****************************************************
    var text_size = modified_substring.length;

    var processed_text = ''; //blank

    var sthiti1 = 0;
    var sthiti2 = 0;
    var chale_chalo = 1;

    var chunk_size = 6000; // this character long text will be processed in one go.

    while (chale_chalo == 1) {
        sthiti1 = sthiti2;

        if (sthiti2 < (text_size - chunk_size)) {
            sthiti2 += chunk_size;
            //while ($data.charAt ( sthiti2 ) != ' ') {sthiti2--;} 

            //This was making problem if there is no 'space' in the whole document.
        } else {
            sthiti2 = text_size;
            chale_chalo = 0
        }

        var modified_substring = $data.substring(sthiti1, sthiti2);

        Replace_Symbols();

        var processed_text = processed_text + modified_substring;

        //document.getElementById("unicode_text").value = "Conversion in progress.." + '\n\n' + 'Conversion of ' + sthiti2 + ' charecters out of ' + text_size + ' completed.';

    }

    return processed_text;


    // --------------------------------------------------


    function Replace_Symbols()

    {

        //substitute array_two elements in place of corresponding array_one elements

        if (modified_substring != "") // if stringto be converted is non-blank then no need of any processing.
        {
            for (input_symbol_idx = 0; input_symbol_idx < array_one_length - 1; input_symbol_idx = input_symbol_idx + 2) {

                //******************************************************
                idx = 0; // index of the symbol being searched for replacement

                while (idx != -1) //while-00
                {

                    modified_substring = modified_substring.replace(array_one[input_symbol_idx], array_one[input_symbol_idx + 1])
                    idx = modified_substring.indexOf(array_one[input_symbol_idx])

                } // end of while-00 loop

            } // end of for loop


            // following statements for adjusting postion of i maatraas.



            modified_substring = modified_substring.replace(/([ि])([कखगघङचछजझञटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])/g, "$2$1");

            modified_substring = modified_substring.replace(/([ि])([्])([कखगघङचछजझञटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])/g, "$2$3$1");

            modified_substring = modified_substring.replace(/([ि])([्])([कखगघङचछजझञटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])/g, "$2$3$1");

            modified_substring = modified_substring.replace(/f/g, "ि");

            //for anuswar shifting

            modified_substring = modified_substring.replace(/([ß])([कखगघङचछजझञटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])/g, "$2$1");

            modified_substring = modified_substring.replace(/([ß])([्])([कखगघङचछजझञटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])/g, "$2$3$1");

            modified_substring = modified_substring.replace(/([ß])([्])([कखगघङचछजझञटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])/g, "$2$3$1");

            modified_substring = modified_substring.replace(/ß/g, "िं");

            //following three statement for adjusting position of reph ie, half r

            modified_substring = modified_substring.replace(/([कखगघचछजझटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])([ािीुूृेैोौंँ]*)¥/g, "¥$1$2ं");

            modified_substring = modified_substring.replace(/([कखगघचछजझटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])([्])¥/g, "¥$1$2");

            modified_substring = modified_substring.replace(/¥/g, "र्");


            modified_substring = modified_substring.replace(/([कखगघचछजझटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])([ािीुूृेैोौंँ]*)&/g, "&$1$2");

            modified_substring = modified_substring.replace(/([कखगघचछजझटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])([्])&/g, "&$1$2");

            modified_substring = modified_substring.replace(/&/g, "र्");


            modified_substring = modified_substring.replace(/([कखगघचछजझटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])([ािीुूृेैोौंँ])Ã/g, "x$1$2");

            modified_substring = modified_substring.replace(/([कखगघचछजझटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])([ािीुूृेैोौंँ]*)Ã/g, "x$1$2");

            modified_substring = modified_substring.replace(/([कखगघचछजझटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])([्])Ã/g, "x$1$2");

            modified_substring = modified_substring.replace(/x/g, "र्");

            modified_substring = modified_substring.replace(/Ã/g, "र्");

            modified_substring = modified_substring.replace(/ंसि/g, "सिं");

            modified_substring = modified_substring.replace(/Je/g, "व");

            modified_substring = modified_substring.replace(/([़])([कखगघङचछजझञटठडड़ढढ़णतथदधनपफबभमयरलळवशषसहक्षज्ञ])/g, "$2$1");

        }
    }
}