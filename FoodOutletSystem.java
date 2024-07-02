import java.util.*;
import java.io.*;
import java.sql.*;
class FoodOutletSystem {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        System.out.println("Driver Loaded Sucessfully");
        String dbURL = "jdbc:mysql://localhost:3306/ip";
        String dbUser = "root";
        String dbPass = "";
        Connection con = DriverManager.getConnection(dbURL , dbUser , dbPass);
        if(con!=null)
        {
            System.out.println("Connection Eshtablish");
        }
        else
        {
            System.out.println("Connection Fail");
        }
        int ch;
        System.out.println("Well Come To RP's Pizzeria");
        do
        {
            System.out.println("Enter Your Choice");
            System.out.println("1.ViewRecords 2.EnterNewOrder 3.MenuCard 4.Exit");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("Enter Name For Seeing Data");
                String n = sc.next();
                String sql = "select * from oredrlist where Name=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1 , n);
                ResultSet rs = pst.executeQuery();
                while(rs.next())
                {
                    System.out.println("Name = " +rs.getString(1));
                    System.out.println("Phone Number = " +rs.getLong(2));
                    System.out.println("Order Name = " +rs.getString(3));
                    System.out.println("Order Details = " +rs.getString(4));
                    System.out.println("Order Type = " +rs.getString(5));
                    System.out.println("Quantity = " +rs.getLong(6));
                    System.out.println("Amount = " +rs.getLong(7));
                }
                break;

                case 2:
                System.out.println("Enter Name");
                String name = sc.next();
                System.out.println("Enter Phone Number");
                long phoneNumber = sc.nextLong();
                int och;
                String ordername="", orderdetails="" , ordertype="";
                long quantity=0 , amount=0;
                do
                {
                    System.out.println("Enter Choice Of Order");
                    System.out.println("1.Pizza 2.Pasta 3.Sandwitch 4.Burger 5.Mexican 6.Breads 7.Exit");
                    och = sc.nextInt();
                    switch(och)
                    {
                        case 1:
                        ordername = "Pizza";
                        int pich;
                        int spch;
                        do
                        {
                            System.out.println("Enter Choice Of Pizza");
                            System.out.println("1.SimplyVeg 2.AuthenticVeg 3.Mexicana 4.PeriPeri 5.7Cheese 6.Margerita 7.Exit");
                            pich = sc.nextInt();
                            switch(pich)
                            {
                                case 1:
                                orderdetails = "SimplyVeg";
                                break;

                                case 2:
                                orderdetails = "AuthenticVeg";
                                break;

                                case 3:
                                orderdetails = "Mexicana";
                                break;

                                case 4:
                                orderdetails = "PeriPeri";
                                break;

                                case 5:
                                orderdetails = "7Cheese";
                                break;

                                case 6:
                                orderdetails = "Margerita";
                                break;

                                case 7:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(pich!=7);
                        do
                        {
                            System.out.println("Enter Size Of Pizza");
                            System.out.println("1.Regular 2.Medium 3.Large 4.Exit");
                            spch = sc.nextInt();
                            long rr = 175;
                            long mr = 350;
                            long lr = 545;
                            switch(spch)
                            {
                                case 1:
                                ordertype = "Regular";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*rr;
                                break;

                                case 2:
                                ordertype = "Medium";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*mr;
                                break;

                                case 3:
                                ordertype = "Large";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*lr;
                                break;

                                case 4:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(spch!=4);
                        break;

                        case 2:
                        ordername = "Pasta";
                        int pach;
                        int sich;
                        do
                        {
                            System.out.println("Enter Choice Of Pasta");
                            System.out.println("1.Penny 2.Fussli 3.Shell 4.Macroni 5.Mix 6.Exit");
                            pach = sc.nextInt();
                            switch(pach)
                            {
                                case 1:
                                orderdetails = "Penny";
                                break;

                                case 2:
                                orderdetails = "Fussli";
                                break;

                                case 3:
                                orderdetails = "Shell";
                                break;

                                case 4:
                                orderdetails = "Macroni";
                                break;

                                case 5:
                                orderdetails = "Mix";
                                break;

                                case 6:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(pach!=6);
                        do
                        {
                            System.out.println("Enter Sause Of Pasta");
                            System.out.println("1.WhiteSause 2.RedSause 3.MixSause 4.Exit");
                            sich = sc.nextInt();
                            long wsr = 180;
                            long rsr = 175;
                            long msr = 210;
                            switch(sich)
                            {
                                case 1:
                                ordertype = "WhiteSause";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*wsr;
                                break;

                                case 2:
                                ordertype = "RedSause";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*rsr;
                                break;

                                case 3:
                                ordertype = "MixSause";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*msr;
                                break;

                                case 4:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(sich!=4);
                        break;

                        case 3:
                        ordername = "Sandwitch";
                        int sch;
                        int ssch;
                        do
                        {
                            System.out.println("Enter Choice Of Sandwitch");
                            System.out.println("1.Vegetable 2.AlooMutter 3.Cheese 4.PannerTikka 5.Mexican 6.Exit");
                            sch = sc.nextInt();
                            switch(sch)
                            {
                                case 1:
                                orderdetails = "Vegetable";
                                break;

                                case 2:
                                orderdetails = "AlooMutter";
                                break;

                                case 3:
                                orderdetails = "Cheese";
                                break;

                                case 4:
                                orderdetails = "PannerTikka";
                                break;

                                case 5:
                                orderdetails = "Mexicana";
                                break;

                                case 6:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(sch!=6);
                        do
                        {
                            System.out.println("Enter Bread Of Sandwitch");
                            System.out.println("1.WhiteBread 2.BrownBread 3.Multigrain 4.Exit");
                            ssch = sc.nextInt();
                            long wr = 120;
                            long br = 130;
                            long mr = 140;
                            switch(ssch)
                            {
                                case 1:
                                ordertype = "WhiteBread";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*wr;
                                break;

                                case 2:
                                ordertype = "BrownBread";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*br;
                                break;

                                case 3:
                                ordertype = "Multigrain";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*mr;
                                break;

                                case 4:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(ssch!=4);
                        break;

                        case 4:
                        ordername = "Burger";
                        int bch;
                        int sbch;
                        do
                        {
                            System.out.println("Enter Choice Of Burger");
                            System.out.println("1.Vegetable 2.Mexican 3.PannerTikka 4.Exit");
                            bch = sc.nextInt();
                            switch(bch)
                            {
                                case 1:
                                orderdetails = "Vegetable";
                                break;

                                case 2:
                                orderdetails = "Mexican";
                                break;

                                case 3:
                                orderdetails = "PannerTikka";
                                break;

                                case 4:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(bch!=4);
                        do
                        {
                            System.out.println("Enter Type Of Bon");
                            System.out.println("1.WhiteBun 2.BrownBun 3.Multigrain 4.Exit");
                            sbch = sc.nextInt();
                            long wbr = 90;
                            long bbr = 85;
                            long mbr = 95;
                            switch(sbch)
                            {
                                case 1:
                                ordertype = "WhiteBun";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*wbr;
                                break;

                                case 2:
                                ordertype = "BrownBun";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*bbr;
                                break;

                                case 3:
                                ordertype = "Multigrain";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*mbr;
                                break;

                                case 4:
                                break;

                                default:
                                break;
                            }
                        }while(sbch!=4);
                        break;

                        case 5:
                        ordername = "Mexican";
                        int mch;
                        int smch;
                        do
                        {
                            System.out.println("Enter Choice Of Mexican");
                            System.out.println("1.Nachos 2.Tacos 3.Enchiladas 4.Qasadias 5.HotPot 6.Exit");
                            mch = sc.nextInt();
                            switch(mch)
                            {
                                case 1:
                                orderdetails = "Nachos";
                                break;

                                case 2:
                                orderdetails = "Tacos";
                                break;

                                case 3:
                                orderdetails = "Enchiladas";
                                break;

                                case 4:
                                orderdetails = "Qasadias";
                                break;

                                case 5:
                                orderdetails = "HotPot";
                                break;

                                case 6:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(mch!=6);
                        do
                        {
                            System.out.println("Enter Sause Of Cheese");
                            System.out.println("1.SimpleCheese 2.YellowCheese 3.Exit");
                            smch = sc.nextInt();
                            long ssr = 160;
                            long ysr = 170;
                            switch(smch)
                            {
                                case 1:
                                ordertype = "SimpleCheese";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*ssr;
                                break;

                                case 2:
                                ordertype = "YellowCheese";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*ysr;
                                break;

                                case 3:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(smch!=3);
                        break;

                        case 6:
                        ordername = "Breads";
                        int brch;
                        int srch;
                        do
                        {
                            System.out.println("Enter Choice Of Breads");
                            System.out.println("1.GarlicBread 2.Bruchita 3.CheeseBread 4.StuffedBread 5.Exit");
                            brch = sc.nextInt();
                            switch(brch)
                            {
                                case 1:
                                orderdetails = "GarlicBread";
                                break;

                                case 2:
                                orderdetails = "Bruchita";
                                break;

                                case 3:
                                orderdetails = "CheeseBread";
                                break;

                                case 4:
                                orderdetails = "StuffedBread";
                                break;

                                case 5:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(brch!=5);
                        do
                        {
                            System.out.println("Enter Choice Of Bread");
                            System.out.println("WhiteBread 2.BrownBread 3.Multigrain 4.Exit");
                            srch = sc.nextInt();
                            long wbr = 120;
                            long bbr = 130;
                            long ybr = 140;
                            switch(srch)
                            {
                                case 1:
                                ordertype = "WhiteBread";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*wbr;
                                break;

                                case 2:
                                ordertype = "BrownBread";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*bbr;
                                break;

                                case 3:
                                ordertype = "Multigrain";
                                System.out.println("Enter Quantity");
                                quantity = sc.nextLong();
                                amount = quantity*ybr;
                                break;

                                case 4:
                                break;

                                default:
                                System.out.println("Enter Valid Choice");
                                break;
                            }
                        }while(srch!=4);
                        break;

                        case 7:
                        break;

                        default:
                        System.out.println("Enter Valid Choice");
                        break;
                    }
                }while(och!=7);
                String isql = "insert into oredrlist values(? , ? , ? , ? , ? , ? , ?)";
                PreparedStatement ipst = con.prepareStatement(isql);
                ipst.setString(1 , name);
                ipst.setLong(2 , phoneNumber);
                ipst.setString(3 , ordername);
                ipst.setString(4 , orderdetails);
                ipst.setString(5 , ordertype);
                ipst.setLong(6 , quantity);
                ipst.setLong(7 , amount);
                ipst.executeUpdate();
                System.out.println("Your Details");
                System.out.println("Name = " +name);
                System.out.println("Phone Number = " +phoneNumber);
                System.out.println("Order Name = " +ordername);
                System.out.println("Order Details = " +orderdetails);
                System.out.println("Order Type = " +ordertype);
                System.out.println("Quantity = " +quantity);
                System.out.println("Amount = " +amount);
                System.out.println("You have to pay rupess "+amount+" amount");
                FileWriter fw = new FileWriter(""+name+".txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Name = " +name);
                bw.newLine();
                bw.flush();
                bw.write("Phone Number = " +phoneNumber);
                bw.newLine();
                bw.flush();
                bw.write("Order Name = " +ordername);
                bw.newLine();
                bw.flush();
                bw.write("Order Details = " +orderdetails);
                bw.newLine();
                bw.flush();
                bw.write("Order Type = " +ordertype);
                bw.newLine();
                bw.flush();
                bw.write("Quantity = " +quantity);
                bw.newLine();
                bw.flush();
                bw.write("Amount = " +amount);
                bw.newLine();
                bw.flush();
                break;

                case 3:
                int mch;
                do
                {
                    System.out.println("Enter Option Of Menu To Seeing MenuCard");
                    System.out.println("1.Pizza 2.Pasta 3.Sandwitch 4.Burger 5.Mexican 6.Breads 7.Exit");
                    mch = sc.nextInt();
                    switch(mch)
                    {
                        case 1:
                        String sql1 = "select * from pizzamenu";
                        PreparedStatement pst1 = con.prepareStatement(sql1);
                        ResultSet r1 = pst1.executeQuery();
                        while(r1.next())
                        {
                            System.out.println("Name = " +r1.getString(1));
                            System.out.println("Regular Rate = " +r1.getLong(2));
                            System.out.println("Medium Rate = " +r1.getLong(3));
                            System.out.println("Large Rate = " +r1.getLong(4));
                        }
                        break;

                        case 2:
                        String sql2 = "select * from pastamenu";
                        PreparedStatement pst2 = con.prepareStatement(sql2);
                        ResultSet r2 = pst2.executeQuery();
                        while(r2.next())
                        {
                            System.out.println("Name = " +r2.getString(1));
                            System.out.println("White Sause Rate = " +r2.getLong(2));
                            System.out.println("Red Sause Rate = " +r2.getLong(3));
                            System.out.println("Mix Sause Rate = " +r2.getLong(4));
                        }
                        break;

                        case 3:
                        String sql3 = "select * from sandwitchmenu";
                        PreparedStatement pst3 = con.prepareStatement(sql3);
                        ResultSet r3 = pst3.executeQuery();
                        while(r3.next())
                        {
                            System.out.println("Name = " +r3.getString(1));
                            System.out.println("White Bread Rate = " +r3.getLong(2));
                            System.out.println("Brown Bread Rate = " +r3.getLong(3));
                            System.out.println("Multi Grain Rate = " +r3.getLong(4));
                        }
                        break;

                        case 4:
                        String sql4 = "select * from burgermenu";
                        PreparedStatement pst4 = con.prepareStatement(sql4);
                        ResultSet r4 = pst4.executeQuery();
                        while(r4.next())
                        {
                            System.out.println("Name = " +r4.getString(1));
                            System.out.println("White Bun Rate = " +r4.getLong(2));
                            System.out.println("Brown Bun Rate = " +r4.getLong(3));
                            System.out.println("Multi Grain Rate = " +r4.getLong(4));
                        }
                        break;

                        case 5:
                        String sql5 = "select * from mexican";
                        PreparedStatement pst5 = con.prepareStatement(sql5);
                        ResultSet r5 = pst5.executeQuery();
                        while(r5.next())
                        {
                            System.out.println("Name = " +r5.getString(1));
                            System.out.println("Simple Cheese Rate = " +r5.getLong(2));
                            System.out.println("Yellow Cheese Rate = " +r5.getLong(3));
                        }
                        break;

                        case 6:
                        String sql6 = "select * from breadsmenu";
                        PreparedStatement pst6 = con.prepareStatement(sql6);
                        ResultSet r6 = pst6.executeQuery();
                        while(r6.next())
                        {
                            System.out.println("Name = " +r6.getString(1));
                            System.out.println("White Bread Rate = " +r6.getLong(2));
                            System.out.println("Brown Bread Rate = " +r6.getLong(3));
                            System.out.println("Multi Grain Rate = " +r6.getLong(4));
                        }
                        break;

                        case 7:
                        break;

                        default:
                        System.out.println("Enter Valid Choice");
                        break;
                    }
                }while(mch!=7);
                break;

                case 4:
                break;

                default:
                System.out.println("Enter Valid Choice");
                break;
            }
        }while(ch!=4);
    }
}