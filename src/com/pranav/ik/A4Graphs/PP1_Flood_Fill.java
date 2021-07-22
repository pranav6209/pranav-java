/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 */
public class PP1_Flood_Fill {
  static int [][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
  static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, ArrayList<ArrayList<Integer>> image) {
      bfs(pixel_row,pixel_column, new_color,image);
      return image;
  }
  
  
  private static void bfs(Integer row, Integer col, Integer color, ArrayList<ArrayList<Integer>> image){
      
      int old_color = image.get(row).get(col);
      if(old_color == color) return;
      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[]{row,col});
      image.get(row).set(col,color); // mark it visited
      
      while(!queue.isEmpty()){
          
          int [] current = queue.poll();
          
          int rSize = image.size();
          int cSize = image.get(0).size();
          
          for(Integer i=0;i<directions.length;i++){
              
              
              Integer r = current[0] + directions[i][0];
              Integer c = current[1] + directions[i][1];
              
              if(r < 0 || c < 0 || r >= rSize || c >= cSize ) continue;
              
              // if not visited, make it visited and add it to queue.
              if(image.get(r).get(c) == old_color){
                  
              image.get(r).set(c,color);   
              queue.add(new int[]{r,c});    
               
                  
              }
              
          }
      }
      
  }

}
