package util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

        //this will include some common methods

        public static String getFirstName(){
            String generatedString = RandomStringUtils.randomAlphabetic(1);// count means how many different letters do u want
            return ("Katberali" + generatedString);
        }
        public static String getLastName(){
            String generatedString = RandomStringUtils.randomAlphabetic(1);
            return ("elishmaas" + generatedString);
        }
        public static String getUserName(){
            String generatedString = RandomStringUtils.randomAlphabetic(3);
            return ("mangsho" + generatedString);
        }
        public static String getPassword(){
            String generatedString = RandomStringUtils.randomAlphabetic(3);
            return ("korma" + generatedString);
        }
        public static String getEmail(){
            String generatedString = RandomStringUtils.randomAlphabetic(3);
            return (generatedString+ "gmail.com");
        }
        public static String empName(){
            String generatedString = RandomStringUtils.randomAlphabetic(1);
            return ("Aloo" + generatedString);
        }
        public static String empSal(){
            String generatedString = RandomStringUtils.randomAlphabetic(5);
            return (generatedString);
        }
        public static String empAge(){
            String generatedString = RandomStringUtils.randomAlphabetic(2);
            return (generatedString);
        }
}
