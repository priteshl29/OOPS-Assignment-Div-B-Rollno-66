import java.util.*;
import java.lang.*;
import java.io.*;
class student{
    String studentName,studentId;
    double ass1,ass2,projectMark,individualtotalmark;
    String grade;

    public student(){

    }

    public student(String a,String b,double c,double d,double x)
    {
        this.studentId=a;
        this.studentName=b;
        this.ass1=c;
        this.ass2=d;
        this.projectMark=x;

    }

    //set methods
    public void setstudentId(String a)
    {
        this.studentId=a;
    }
    public void setstudentName(String b)
    {
        this.studentName=b;
    }
    public void setAss1(double c)
    {
        this.ass1=c;
    }
    public void setAss2(double d)
    {
        this.ass2=d;
    }
    public void setprojectMark(double x)
    {
        this.projectMark=x;
    }
    //get methods
    
    public  String getstudentId()
    {
        return this.studentId;
    }
    public String getstudentName()
    {
        return this.studentName;
    }
    public double getAss1()
    {
        return this.ass1;
    }
    public double getAss2()
    {
        return this.ass2;
    }
    public double getprojectMark()
    {
        return this.projectMark;
    }

    // total marks calculation 
    public double calculate()
    {
        individualtotalmark=this.ass1+this.ass2+this.projectMark;
        return individualtotalmark;
    }

    public String getGrade(){
        if(individualtotalmark < 50)
            grade="F";
        else if(individualtotalmark >=50 && individualtotalmark <65)
            grade = "P";
        else if(individualtotalmark >=65 && individualtotalmark <75)
            grade = "C";
        else if(individualtotalmark >=75 && individualtotalmark <85)
            grade = "D";
        else if(individualtotalmark >=85)
            grade="HD";
        
        return grade;
    }
 
} 

class GradingSystemMenu{
    public static void main(String args[]){
        int i,cnt=0,ch=0;

        
        String a="",b="";
        double c=0,d=0,x=0;
         
        double min=100,max=0,avg=0;
        
        double ans=0;

        student st[]=new student[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do{
            System.out.println("\n1. Enter Student record \n2. Display all students grade \n3. Display statistics\n4. Exit\n\nEnter choice : ");
            
            try{
                ch=Integer.parseInt(br.readLine());
            }catch(Exception e){
                System.out.println(e);
            }

            switch(ch){

                case 1: st[cnt]=new student();
                        // accept values locally
                        try{
                            System.out.println("Enter StudentId  : ");
                            a=br.readLine();
                            System.out.println("Enter Student Name : ");
                            b=br.readLine();
                            System.out.println("Enter Assignment 1 marks : ");
                            c=Double.parseDouble(br.readLine());
                            System.out.println("Enter Assignment 2 marks : ");
                            d=Double.parseDouble(br.readLine());
                            System.out.println("Enter Project marks : ");
                            x=Double.parseDouble(br.readLine());
                        }catch(Exception e ){
                            System.out.println(e);
                        }

                        // set values in the student array
                        st[cnt].setstudentId(a);
                        st[cnt].setstudentName(b);
                        st[cnt].setAss1(c);
                        st[cnt].setAss2(d);
                        st[cnt].setprojectMark(x);

                        // increment the counter
                        cnt++;

                    break;
                case 2:
                        if(cnt==0){
                            System.out.println("Enter at least one record!!");
                            break;
                        }
                        else{
                                System.out.println("Roll\tName\tAss1\tAss2\tProj\tTotal\tGrade");

                                for(i=0;i<cnt;i++){
                                    System.out.print( (a=st[i].getstudentId() )+"\t");
                                    System.out.print( (b=st[i].getstudentName() )+"\t");
                                    System.out.print( (c=st[i].getAss1() )+"\t");
                                    System.out.print( (d=st[i].getAss2() )+"\t");
                                    System.out.print( (x=st[i].getprojectMark() )+"\t");
                                    System.out.print( (st[i].calculate() )+"\t");
                                    System.out.print( (st[i].getGrade()  )+"\t");
                                    System.out.println();
                                }
                                
                                
                            }
                    break;
                case 3: if(cnt==0){
                            System.out.println("Enter at least one record!");
                            break;
                        }
                        else{
                            // Find minumum
                                for(i=0;i<cnt;i++){
                                    if( (ans=st[i].calculate()) < min){
                                        min=ans;
                                        a=st[i].getstudentName();
                                    }
                                }
                                // Find maximum
                                
                                for(i=0;i<cnt;i++){
                                    if( (ans=st[i].calculate()) > max){
                                        max=ans;
                                        b=st[i].getstudentName();
                                    }

                                }
                                // Find average of all students
                                for(i=0;i<cnt;i++){
                                    avg+= st[i].calculate() / cnt;
                                }
                            System.out.println("Minimum marks scored by "+a+" : "+min);
                            System.out.println("Maximum marks scored by "+b+" : "+max);
                            System.out.println("Average marks scored by class : "+avg);
                        }
                        avg=0;
                    break;

            }

        }while(ch!=4);
    }
}


