import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class SetAnalysis
{
public static void main(String[] args){
Scanner scan = new Scanner(System.in);
Set<Integer> set1 = new LinkedHashSet<Integer>();
Set<Integer> set2 = new LinkedHashSet<Integer>();
System.out.print("Creating First Set");
for(int i = 0; i < 3; i++){
try{
Thread.sleep(1000);
}
catch(Exception e){System.out.println("Yo");}
System.out.print(".");
}
System.out.println();
String answer = "";
while(!answer.equals("y")){
System.out.println("Enter a value:");
set1.add(scan.nextInt());
System.out.println("Are you done? y/n");
scan.nextLine();
answer = scan.nextLine();
}
System.out.println("Enter your second set values:");
answer = "";
while(!answer.equals("y")){
System.out.println("Enter a value:");
set2.add(scan.nextInt());
System.out.println("Are you done? y/n");
scan.nextLine();
answer = scan.nextLine();
}
System.out.println("Cardinality of set 1: " + set1.size());
System.out.println("Cardinality of set 2: " + set2.size());
Set<Integer> union = new TreeSet<Integer>(set1);
union.addAll(set2);
System.out.println("Union of Set 1 and Set 2: " + union);
System.out.println();
Set<Integer> intersection = new TreeSet<Integer>(set1);
intersection.retainAll(set2);
System.out.println("Intersection of Set 1 and Set 2: " + intersection);
System.out.println();
Set<Integer> sym = new TreeSet<Integer>(set1);
sym.addAll(set2);
sym.removeAll(intersection);
System.out.println("Symmetrical Difference of Set 1 and Set 2: " + sym);
Set<Set<Integer>> powerSet = getPowerSet(set1);
System.out.println("Power set of Set 1: " + powerSet);
Set<Set<Integer>> powerSet2 = getPowerSet(set2);
System.out.println("Power set of Set 1: " + powerSet2);
}
public static Set<Set<Integer>> getPowerSet(Set<Integer> set){
Set<Set<Integer>> powerSet = new LinkedHashSet<Set<Integer>>();
if(set.size() == 0){
powerSet.add(new LinkedHashSet<Integer>());
return powerSet;
}
List<Integer> list = new ArrayList<Integer>(set);
int head = list.get(0);
Set<Integer> rest = new LinkedHashSet<Integer>();
for(int i = 1; i < list.size(); i++){
rest.add(list.get(i));
}
for(Set<Integer> i : getPowerSet(rest)){
Set<Integer> newSet = new LinkedHashSet<Integer>();
newSet.add(head);
newSet.addAll(i);
powerSet.add(newSet);
powerSet.add(i);
}
return powerSet;
}
}