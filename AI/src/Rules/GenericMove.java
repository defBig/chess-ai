package Rules;

import java.util.ArrayList;

public class GenericMove {
    

    protected static ArrayList<Coordinate> bishopGen (byte pos_i, byte pos_j, Board b) throws BoardOutOfBoundsException{
        Coordinate x;
        ArrayList<Coordinate> list = new ArrayList<Coordinate>();
        for (byte i = 1; (pos_i + i) < 8; i++) {
            if (pos_j + i < 8 && b.getPiece(pos_i + i, pos_j + i) == 'o') {
              x = new Coordinate(pos_i, pos_j, pos_i + i, pos_j + i);
              list.add(x);
            }
            else {
              break;
            }
          }
        for (byte i = 1; (pos_i + i) < 8; i++) {
            if (pos_j - i >= 0 && b.getPiece(pos_i + i, pos_j - i) == 'o') {
              x = new Coordinate(pos_i, pos_j, pos_i + i, pos_j - i);
              list.add(x);
              }
            else {
              break;
              }
          }
        for (byte i = 1; (pos_i - i) >= 0; i++) {
            if (pos_j + i < 8 && b.getPiece(pos_i - i, pos_j + i) == 'o') {
              x = new Coordinate(pos_i, pos_j, pos_i - i, pos_j + i);
              list.add(x);
            }
            else {
              break;
            }
          }
        for (byte i = 1; (pos_i - i) >= 0; i++) {
            if ((pos_j - i) >= 0 && b.getPiece(pos_i - i, pos_j - i) == 'o') {
              x = new Coordinate(pos_i, pos_j, pos_i - i, pos_j - i);
              list.add(x);
            }
            else {
              break;
            }
          }
        return list;
    }

    protected static ArrayList<Coordinate> rookGen (byte pos_i, byte pos_j, Board b) throws BoardOutOfBoundsException{
        ArrayList<Coordinate> moves = new ArrayList<Coordinate>();
        Coordinate x; 
        boolean pathBlocked = false;
        byte t = 0;

        //Para uma fileira
        for (byte j = 0; j < pos_j; j++) {
          if(b.getPiece(pos_i, j) != 'o') {
              pathBlocked = true;
              t = j;
              }
            }
          if (pathBlocked == true) {
            if (!(b.hasSameColor(pos_i, pos_j, pos_i, t))) {
              x = new Coordinate(pos_i, pos_j, pos_i, t);
              moves.add(x);
            }
            for (byte j = (byte)(t+1); j < pos_j; j++) {
              x = new Coordinate(pos_i, pos_j, pos_i, j);
              moves.add(x);
            }
          }
          pathBlocked = false;
        for (byte j = (byte) (pos_j + 1); j < 8; j++) {
            if (b.getPiece(pos_i, j) == 'o') {
              x = new Coordinate(pos_i, pos_j, pos_i, j);
              moves.add(x);
            }
            else {
              if (b.hasSameColor(pos_i, pos_j, pos_i, j) == false) {
                x = new Coordinate(pos_i, pos_j, pos_i, j);
                moves.add(x);
              }
              break;
            }
          }
          //Para uma coluna 
          for (byte i = 0; i<pos_i; i++) {
            if(b.getPiece(i, pos_j) != 'o') {
              pathBlocked = true;
              t = i;
              }
          }
          if (pathBlocked == true) {
            if (!(b.hasSameColor(pos_i, pos_j, t, pos_j))) {
              x = new Coordinate(pos_i, pos_j, t, pos_j);
              moves.add(x);
            }
            for (byte i = (byte)(t+1); i < pos_i; i++) {
              x = new Coordinate(pos_i, pos_j, i, pos_j);
              moves.add(x);
            }
          }
          for (byte i = (byte) (pos_i + 1); i<8; i++) {
            if (b.getPiece(i, pos_j) == 'o') {
              x = new Coordinate(pos_i, pos_j, i, pos_j);
              moves.add(x);
            }
            else {
              if(!(b.hasSameColor(pos_i, pos_j, i, pos_j))) {
                x = new Coordinate(pos_i, pos_j, i, pos_j);
                moves.add(x);
              }
              break;
            }
          }
          return moves;
    }
}