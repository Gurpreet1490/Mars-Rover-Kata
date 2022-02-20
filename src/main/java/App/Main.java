package App;

import model.*;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

  public static void main(String[] args){

      Scanner scanner = new Scanner(in);
      out.print("Enter dimension of Plateau: ");
      String dimension = scanner.nextLine();
      //Plateau plateau = createPlateau(dimension);
      MissionControl missionControl = createPlateau(dimension);

      String name = "MyRover";
      out.print("Add information for " + name + "(in form of x and y).");
      String landedInfo = scanner.nextLine();
      out.print("Initial direction for rover " + name);
      String direction = scanner.nextLine();
      Rover rover = landRover(name, missionControl, landedInfo, direction);

      while (true) {

          try{
              out.println("Report: " + rover.roverStatus());
              out.print(name + " Enter instruction in form LM...: ");
              String instruction = scanner.nextLine();
              InstructionType[] instructionsCollection = new Instructions(instruction).getInstruction();
              rover.command(instructionsCollection);
          } catch (Exception ex){
              out.println(ex.getMessage());
          }
      }
  }

  private static MissionControl createPlateau(String dimensions){
      String[] axis = dimensions.split(" ");
      int maxX = Integer.parseInt(axis[0]);
      int maxY = Integer.parseInt(axis[1]);
      return new MissionControl(maxX, maxY);
  }

  private static Rover landRover(String id, MissionControl missionControl, String landedInfo, String direction){
      Rover rover = new Rover(id);
      String[] axis = landedInfo.split(" ");
      int x = Integer.parseInt(axis[0]);
      int y = Integer.parseInt(axis[1]);
      rover.landRoverPlateau(missionControl, new Position(x, y), Rover.approachingTo(direction.charAt(0)));
      return rover;
  }
}
