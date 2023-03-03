import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option ;
        String[][] condo = new String[][]{};
        int floor ;
        int room = 0;
        boolean isCondition = false ;

        do{
            System.out.println(" -------------------- Set Up Condo --------------------------- ");
            System.out.print("Enter number of floor: "); // row
            floor = input.nextInt();
            if(floor>0){
                System.out.print("Enter number of room: ");
                room = input.nextInt();
                if(room>0){
                    isCondition = true  ;
                    condo = new String[floor][room];
                    System.out.println(">>>> Congratulation ! You have set up a condo  <<<<");
                    System.out.println("You have set up a condo that has : ");
                    // ternary operator
                    System.out.println("Floor = "+floor + " floor"+(floor>=2?"s":"")); // 1 floor , 2 floors not 1 floors
                    System.out.println("Room  = "+ room + " room"+(room>=2?"s":"")); // 1 room , 2 rooms not 1 rooms
                }else
                    isCondition = false;
            }else {
                isCondition = false;
            }

        }while (!isCondition);


        do{
            System.out.println("-------------------- Condo Management System ------------ ");
            System.out.println("1. Buy Condo ");
            System.out.println("2. Sell Condo ");
            System.out.println("3. Search Condo");
            System.out.println("4. Display Condo Information ");
            System.out.println("5. Exit ");
            System.out.print(" Choose your option : ");
            option = input.nextInt();
            switch (option){
                case  1 :
                    int selectedFloor;
                    int selectedRoom;
                    boolean isFloorRoomValid = false;

                    do{
                        System.out.println("--------------------- Buy the condo ------------------------");
                        System.out.print(" Enter your desire floor : ");
                        selectedFloor =  input.nextInt();

                        // selectedfloor > 0  <= floors
                        if(selectedFloor>0 && selectedFloor<=floor){
                            System.out.print(" Enter your desire room : ");
                            selectedRoom = input.nextInt();
                            if(selectedRoom>0 && selectedRoom<=room){
                                isFloorRoomValid = true;
                                if(condo[selectedFloor-1][selectedRoom-1]!=null){
                                    System.out.println("Sorry! the condo is already owned by someone else . Try different condo");
                                }else {
                                    System.out.print(" Enter your buyer's name:  ");
                                    input.nextLine();
                                    condo[selectedFloor-1][selectedRoom-1] = input.nextLine();
                                    System.out.println(">>>>>> Successfully bought a condo <<<<<<<<<<");

                                }
                            }else {
                                System.out.println("Error : Room can be selected from 1 to "+ room);
                            }
                        }else {
                            System.out.println("Error : Floor can be selected from 1 to "+floor);
                        }

                        Scanner scanner1 =  new Scanner(System.in);
                        System.out.println("------------------------ Press any keys to continue ---------------------------");
                        scanner1.nextLine();

                    }while (!isFloorRoomValid) ;

                    break;
                case 2 :
                    int sellFloor;
                    int sellRoom;
                    String condoOwner;
                    boolean isSellFloorRoomValid = false;
                    do {
                        System.out.println("---------------------- Sell the condo ---------------------");
                        System.out.println("Enter your floor: ");
                        sellFloor = input.nextInt();
                        if(sellFloor>0 && sellFloor <= floor){

                            System.out.println("Enter your room : ");
                            sellRoom = input.nextInt();
                            if(sellRoom>0 && sellRoom <=room){
                                isSellFloorRoomValid = true;
                                if(condo[sellFloor-1][sellRoom-1]==null){
                                    System.out.println("Error: You cannot sell this condo ! Because it's not own by anyone else......");
                                }else {
                                    System.out.println(" Enter your name : ");
                                    input.nextLine(); // clear buffer
                                    condoOwner = input.nextLine();
                                    if(condo[sellFloor-1][sellRoom-1].equals(condoOwner)){
                                        condo[sellFloor -1][sellRoom-1] = null ;
                                    }else {
                                        System.out.println(" You cannot sell it. Invalid owner! You are not the owner fo this condo ");
                                    }
                                }
                            }else System.out.println("Error : Room can be selected from 1 to "+room );
                        }else {
                            System.out.println("Error : Floor can be selected from 1 to "+floor);
                        }
                        Scanner scanner3 =  new Scanner(System.in);
                        System.out.println("------------------------ Press any keys to continue ---------------------------");
                        scanner3.nextLine();
                    }while (!isSellFloorRoomValid);
                    break;
                case 3 :
                    int searchOption ;
                    System.out.println(" ------------------------- Search  Condo Information ---------------");
                    System.out.println(" 1. Search By Owner's name ");
                    System.out.println(" 2. Search By Floor ");
                    System.out.println(" 3. Search By Room & Floor ");
                    System.out.print("Choose your option (1 - 3 ) : ");
                    searchOption = input.nextInt();

                    switch (searchOption){
                        case 1 :
                            boolean isUserExist = false;
                            String searchOwnerName;
                            System.out.println("----------------------------- Search By Owner's Name ---------------------");
                            System.out.print("Enter Owner Name to Search : ");
                            input.nextLine();
                            searchOwnerName = input.nextLine();
                            for(int i = 0; i < condo.length; i++){
                                for(int j = 0; j<condo[i].length ; j++){
                                    if(searchOwnerName.equals(condo[i][j])){
                                        isUserExist = true;
                                        System.out.println("Here is the information of the owner : ");
                                        System.out.println(" Owner name is : "+condo[i][j]);
                                        System.out.println(" No floor is : "+(i+1));
                                        System.out.println(" No room is : "+(j+1));
                                    }
                                }
                            }
                            if(!isUserExist){
                                System.out.println("The Owner name that you just searched doesn't exist ..... ! Try again..");
                            }
                            break;
                        case 2 :
                            System.out.println(" ----------------------------- Search By Floor --------------------------");

                            break;
                        case 3 :
                            System.out.println("--------------------------- Search By Room & Floor -------------------");
                            break;
                        default:
                            System.out.println(" Wrong option! Available option is from 1 to 3 ");
                            break;
                    }
                    Scanner scanner4 = new Scanner(System. in);
                    System.out.println("------------------------------- Press Any Keys to continue --------------------");
                    scanner4.nextLine();
                    break;
                case 4 :
                    System.out.println(" ------------------------ Display Condo Information ------------------------ ");


                    for(int i = 0; i< condo.length; i++){
                        for (int j = 0; j<condo[i].length; j++){
                            System.out.print(" \t"+condo[i][j]);
                        }
                        System.out.println();
                    }

                    Scanner scanner =  new Scanner(System.in);
                    System.out.println("------------------------ Press any keys to continue ---------------------------");
                    scanner.nextLine();
                    break;
                case 5 :
                    System.out.println("................... Exit the program ...................");
                    break;
                default:
                    System.out.println("You have chosen the wrong option... Choose again from (1 - 6 ) ");
                    break;
            }
        }while (option!= 5 );
    }
}