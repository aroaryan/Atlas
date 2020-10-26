import java.util.*;
public class atlas
{
    /* List of all official countries as of October 2018. All are in lowercase as the user's inputted
     * string is converted to lowercase for easier comparision. Two countries official names have 
     * been altered : 'côte d’ivoire' to 'cote d'ivoire' (To allow standard keyboard users to input 
     * it)and 'united states' to 'united states of america' */
    
    static String valid_countries[] = {"afghanistan","albania","algeria","andorra","angola"
        ,"antigua and barbuda","argentina","armenia","australia","austria","azerbaijan","the bahamas"
        ,"bahrain","bangladesh","barbados","belarus","belgium","belize","benin","bhutan","bolivia"
        ,"bosnia and herzegovina","botswana","brazil","brunei","bulgaria","burkina faso","burundi"
        ,"cabo verde","cambodia","cameroon","canada","central african republic","chad","chile"
        ,"china","colombia","comoros","democratic republic of the congo","republic of the congo"
        ,"costa rica","cote d'ivoire","croatia","cuba","cyprus","czech republic","denmark","djibouti"
        ,"dominica","dominican republic","east timor","ecuador","egypt","el salvador"
        ,"equatorial guinea","eritrea","estonia","ethiopia","fiji","finland","france","gabon"
        ,"the gambia","georgia","germany","ghana","greece","grenada","guatemala","guinea"
        ,"guinea-bissau","guyana","haiti","honduras","hungary","iceland","india","indonesia","iran"
        ,"iraq","ireland","israel","italy","jamaica","japan","jordan","kazakhstan","kenya","kiribati"
        ,"north korea","south korea","kosovo","kuwait","kyrgyzstan","laos","latvia","lebanon"
        ,"lesotho","liberia","libya","liechtenstein","lithuania","luxembourg","macedonia"
        ,"madagascar","malawi","malaysia","maldives","mali","malta","marshall islands","mauritania"
        ,"mauritius","mexico","federated states of micronesia","moldova","monaco","mongolia"
        ,"montenegro","morocco","mozambique","myanmar","namibia","nauru","nepal","netherlands"
        ,"new zealand","nicaragua","niger","nigeria","norway"    ,"oman","pakistan","palau","panama"
        ,"papua new guinea","paraguay","peru","philippines","poland","portugal","quatar","romania"
        ,"russia","rwanda","saint kitts and nevis","saint lucia","saint vincent and the grenadines"
        ,"samoa","san marino","sao tome and principe","saudi arabia","senegal","serbia","seychelles"
        ,"sierra leone","singapore","slovakia","slovenia","solomon islands","somalia","south africa"
        ,"spain","sri lanka","sudan","south sudan","suriname","swaziland","sweden","switzerland"
        ,"syria","taiwan","tajikistan","tanzania","thailand","togo","tonga","trinidad and tobago"
        ,"tunisia","turkey","turkmenistan","tuvalu","uganda","ukraine","united arab emirates"
        ,"united kingdom","united states of america","uruguay","uzbekistan","vanuatu","vatican city"
        ,"venezuela","vietnam","yemen","zambia","zimbabwe"};
    
    static String used_countries[] = new String[200]; 
    static int used_country_count = 0; 
    
    public static int difficulty_setter(String choice)
    {
        int output;
        if(choice.equals("easy"))
        {
            output = 45;
        }
        else if(choice.equals("medium"))
        {
            output = 75;
        }
        else if(choice.equals("hard"))
        {
            output = 115;
        }
        else if(choice.equals("perfect"))
        {
            output = 10000;
        }
        else
        {
            output = 0;
        }
        return(output);
    }
    
    public static boolean is_valid_country(String country)
    {
        boolean output = false;
        for(int i = 0; i<valid_countries.length; i++)
        {
            if(valid_countries[i].equals(country))
            {
                output = true;
                break;
            }
        }
        return output;
    }
    
    public static boolean is_repeat_country(String country)
    {
        boolean output = false; 
        for(int i = 0; i<used_countries.length; i++)
        {
            if(country.equals(used_countries[i]))
            {
                output = true;
            }
        }
        return(output);
    }
    
    public static void main() throws java.lang.InterruptedException
    {
        Scanner sc = new Scanner(System.in);            
        int     country_memory              = 0;
        String  inputted_country            = "";
        char    start_letter;               
        boolean atlas_active                = false;    
        boolean valid_country               = false;
        boolean repeat_country              = false;
        int     country_location;
        boolean computer_found_country      = false;
        boolean computer_found_used_country = false;   
        int     random_country_index        = 0;
        int     computer_request_for_time   = 0;
        boolean computer_used_request       = false;
        
        System.out.println("Hi, I am a chatbot.");
        Thread.sleep(750);
        System.out.println("What is your name?");
        String name = sc.nextLine();
        Thread.sleep(750);
        System.out.println("");
        System.out.println("Hi, " + name);
        Thread.sleep(750);
        System.out.println("Let's play a game of atlas.");
        while(country_memory == 0)
        {
            Thread.sleep(750);
            System.out.println("Tell me, how difficult should I make it for you? (Easy, Medium, Hard or Perfect) : ");
            String difficulty = sc.nextLine();
            difficulty = difficulty.toLowerCase();
            country_memory = atlas.difficulty_setter(difficulty);
            if(country_memory == 0)
            {
                Thread.sleep(750); 
                System.out.println("That is not a valid difficulty.");
            }
        }
        Thread.sleep(750);
        System.out.println("");
        System.out.println("Ok, you start.");
        valid_country = false;
        while(valid_country == false)
        {
            Thread.sleep(750);
            System.out.println("Name a country : ");
            inputted_country = sc.nextLine();
            inputted_country = inputted_country.toLowerCase();
            valid_country = atlas.is_valid_country(inputted_country);
            if(valid_country == false)
            {
                Thread.sleep(750);
                System.out.println("It is not a valid country.");
                Thread.sleep(750);
                System.out.println("Let's try that again");
            }
            else
            {
                start_letter = inputted_country.charAt(inputted_country.length() - 1);
                used_countries[used_country_count] = inputted_country;
                used_country_count++;
                for(int i = 0; i<=valid_countries.length - 1; i++)
                {
                    if(inputted_country.equals(valid_countries[i]))
                    {
                        valid_countries[i] = " ";
                    }
                }
            }
        }
        
        atlas_active = true;
        start_letter = inputted_country.charAt(inputted_country.length() - 1);
        while(atlas_active == true)
        {
            //Computer's Turn Starts
            System.out.println("");
            computer_found_country = false;
            computer_used_request = false;
            Thread.sleep(750);
            System.out.println("I have to think a country starting with " + start_letter);
            
            for(int i = 1; i<=country_memory; i++)
            {
                random_country_index = (int)Math.round(Math.random() * (valid_countries.length - 1));
                if(valid_countries[random_country_index].charAt(0) == ' ')
                {
                    if(computer_used_request == false)
                    {
                        computer_request_for_time = (int)Math.round(Math.random() * 2);
                        Thread.sleep(750);
                        switch(computer_request_for_time)
                        {
                            case 0:
                                System.out.println("Give me a moment to think");
                                break;
                            case 1:
                                System.out.println("This is a difficult one");
                                break;
                            case 2:
                                System.out.println("Just one second");
                                break;
                            default:
                                System.err.println("There is an error with the random number generator");
                        }
                        computer_used_request = true;
                        Thread.sleep(1000);
                    }
                }
                if(valid_countries[random_country_index].charAt(0) == start_letter)
                {
                    computer_found_country = true;
                    used_countries[used_country_count] = valid_countries[random_country_index];
                    Thread.sleep(750);
                    System.out.println(valid_countries[random_country_index]);
                    start_letter = valid_countries[random_country_index].charAt(valid_countries[random_country_index].length() - 1);
                    valid_countries[random_country_index] = " ";
                    used_country_count++;
                    break;
                }
            }
            
            if(computer_found_country == false)
            {
                computer_found_used_country = false;
                if(used_country_count > 1)
                {
                    for(int i = 1; i<=country_memory; i++)
                    {
                        random_country_index = (int)Math.round(Math.random() * ((used_country_count)-1));
                        if(used_countries[random_country_index].charAt(0) == start_letter && used_countries[random_country_index].charAt(0) != ' ')
                        {   
                            computer_found_used_country = true;
                            System.out.println(used_countries[random_country_index]);
                            Thread.sleep(750);
                            System.out.println("But this country has already been used");
                            Thread.sleep(750);
                            System.out.println("So I guess you win");
                            break;
                        }
                    }
                }
                if(computer_found_used_country == false)
                {
                    Thread.sleep(750);
                    System.out.println("I could not think of a country");
                    Thread.sleep(750);
                    System.out.println("So I guess you win");
                }
                break;
            }
            
            //User's turn starts
            System.out.println("");
            Thread.sleep(750);
            System.out.println("Now name a country that starts with '" + start_letter +"'");
            inputted_country = sc.nextLine();
            inputted_country = inputted_country.toLowerCase();
            valid_country = false;
            valid_country = atlas.is_valid_country(inputted_country);
            if(valid_country == false)
            {
                repeat_country = atlas.is_repeat_country(inputted_country);
                if(repeat_country == true)
                {
                    Thread.sleep(750);
                    System.out.println("This country has already been used");
                }
                else
                {
                    Thread.sleep(750);
                    System.out.println("This is not a country");
                }
                Thread.sleep(750);
                System.out.println("So, you lose");
                break;
            }
            else if(inputted_country.charAt(0) != start_letter)
            {
                Thread.sleep(750);
                System.out.println("That country does not start with " + start_letter);
                Thread.sleep(750);
                System.out.println("So, you lose");
                break;
            }
            else
            {
                start_letter = inputted_country.charAt(inputted_country.length()-1);
                used_countries[used_country_count] = inputted_country;
                used_country_count++;
                for(int i = 0; i<=valid_countries.length - 1; i++)
                {
                    if(inputted_country.equals(valid_countries[i]))
                    {
                        valid_countries[i] = " ";
                    }
                }
            }
        }
    }
}