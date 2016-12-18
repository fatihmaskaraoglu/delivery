package Util;

import java.awt.Point;
import java.sql.SQLException;

import DAOs.AddressDAO;
import DAOs.StreetDAO;
import dataModels.Street;
import dataModels.Address;	

public class Util{
	
	public static Point intersection(Address add1, Address add2) {
		Street s1 = null;
		Street s2 = null;
		int id1 = add1.getStreetId();
		int id2 = add2.getStreetId();
		StreetDAO sdao = new StreetDAO();
		try {
			s1 = sdao.findById(id1);
			s2 = sdao.findById(id2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return intersection(s1.getX1(), s1.getY1(), s1.getX2(), s1.getY2(), s2.getX1(), s2.getY1(), s2.getX2(), s2.getY2());
	}
	
	
	public static Point intersection(float x1,float y1,float x2,float y2, float x3, float y3, float x4,float y4) {
		float d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
		if (d == 0) return null;	  
		float xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
		float yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
		return new Point((int)xi,(int)yi);
	}



	  /**
	   * Returns closest point on segment to point
	   * 
	   * @param sx1
	   *            segment x coord 1
	   * @param sy1
	   *            segment y coord 1
	   * @param sx2
	   *            segment x coord 2
	   * @param sy2
	   *            segment y coord 2
	   * @param px
	   *            point x coord
	   * @param py
	   *            point y coord
	   * @return closets point on segment to point
	   */
	  public static Point getClosestPointOnSegment(int sx1, int sy1, int sx2, int sy2, int px, int py)
	  {
	    double xDelta = sx2 - sx1;
	    double yDelta = sy2 - sy1;

	    if ((xDelta == 0) && (yDelta == 0))
	    {
	      throw new IllegalArgumentException("Segment start equals segment end");
	    }

	    double u = ((px - sx1) * xDelta + (py - sy1) * yDelta) / (xDelta * xDelta + yDelta * yDelta);

	    final Point closestPoint;
	    if (u < 0)
	    {
	      closestPoint = new Point(sx1, sy1);
	    }
	    else if (u > 1)
	    {
	      closestPoint = new Point(sx2, sy2);
	    }
	    else
	    {
	      closestPoint = new Point((int) Math.round(sx1 + u * xDelta), (int) Math.round(sy1 + u * yDelta));
	    }

	    return closestPoint;
	  }
	}
