package org.example;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Contact
{
    Logger logger=Logger.getLogger("com.api.jar");

    Node rootNode=null;
    int count=0;
    public void addcontact(String name,long number,String email){
        if(this.rootNode == null){
            this.rootNode= new Node(name,number, email);
            this.count++;
        }else{
            var temp = this.rootNode;
            while(temp.nextNode != null){
                temp = temp.nextNode;
            }
            temp.nextNode = new Node(name,number,email);
            this.count++;
        }
        logger.info("successfully Contact details added ");
    }
    public void removecontact(){
        Node temp1 = this.rootNode;
        Node temp2=this.rootNode.nextNode;
        if(temp1.nextNode==null)
        {
            logger.info("only one contact is available ");
        }
        else {
            while (temp2.nextNode != null) {
                temp1 = temp1.nextNode;
                temp2 = temp2.nextNode;
            }

            temp1.nextNode = null;
            logger.info("Successfully Removed the contact details");
        }
    }

    public void display() {
        Node temp = this.rootNode;

        if (temp == null) {
            logger.info(" LinkedList Is empty!");
        } else {
            while (temp != null) {
                logger.info(temp.name);
                logger.log(Level.INFO,Long.toString(temp.number),+temp.number);
                logger.info(temp.email);
                temp = temp.nextNode;
            }

        }
    }
    public void searchcontact(String name)
    {
        Node temps=this.rootNode;
        while(temps.nextNode!=null)
        {
            if(temps.name.equals(name))
            {
                logger.info("contact person details");
                logger.log(Level.INFO,temps.name);
                logger.log(Level.INFO,Long.toString(temps.number),+temps.number);
                logger.log(Level.INFO,temps.email);
                break;
            }
            else {
                temps=temps.nextNode;
            }
        }
        if(temps.nextNode==null &&temps.name.equals(name))
        {
            logger.info("contact person details");
            logger.log(Level.INFO,temps.name);
            logger.log(Level.INFO,Long.toString(temps.number),+temps.number);
            logger.log(Level.INFO,temps.email);
        }
    }
    public static void main(String[] args)
    {
        Contact list = new Contact();
        Scanner sc=new Scanner(System.in);
        Logger logger=Logger.getLogger("com.api.jar");
        int choice;
        String name;
        long number;
        String email;
        while(true)
        {
            logger.info("\n1)ADD CONTACT \n2)REMOVE CONTACT \n3) SEARCH CONTACT PERSON \n4)DISPLAY CONTACT DETAILS  \n5)EXIT");
            logger.info("Choose any one of the option in the above: ");
            choice=sc.nextInt();
            if(choice==1)
            {
                logger.info("Enter the name :");
                name=sc.next();
                logger.info("Enter the mobile number");
                number=sc.nextLong();
                logger.info("Enter the email ");
                email=sc.next();
                list.addcontact(name,number,email);
            }
            else if(choice==2)
            {
                list.removecontact();
            }
            else if(choice==3)
            {
                logger.info("Enter the searching contact name ");
                name=sc.next();
                list.searchcontact(name);

            }
            else if(choice==4)
            {
                list.display();
            }
            else if(choice==5)
            {
                break;
            }
        }
    }
}