package com.interviewcake;

import org.junit.jupiter.api.Test;

public class RectangularLove {

    /**
     * A crack team of love scientists from OkEros (a hot new dating site) have devised a way to represent
     * dating profiles as rectangles on a two-dimensional plane.
     *
     * They need help writing an algorithm to find the intersection of two users' love rectangles.
     */
    public Rectangle findOverlap(Rectangle r1, Rectangle r2){
        return null;
    }

    private Rectangle findOverlapRect(Rectangle r1, Rectangle r2){
        int r1A = r1.bottomY - (r1.height + r1.bottomY);
        int r1B = (r1.width + r1.leftX) - r1.leftX;
        int r1C = r1A * (r1.width + r1.leftX) + r1B * (r1.height + r1.bottomY);
        int r2A = r2.bottomY - (r2.height + r2.bottomY);
        int r2B = (r2.width + r2.leftX) - r2.leftX;
        int r2C = r2A * (r2.width + r2.leftX) + r2B * (r2.height + r2.bottomY);
        if(r1A*r2B - r2A * r1B == 0) return null;
        else{
            int leftX = r2B * r1C - r1B * r2C;
            int bottomY = (r1A * r2C - r2A * r1C);
            return new Rectangle(leftX, bottomY, -1, -1);
        }
    }

    @Test
    public void testFindOverlap(){
        Rectangle r1 = new Rectangle(1,2,2,2);
        Rectangle r2 = new Rectangle(2,1,2,2);
        System.out.println(findOverlapRect(r1,r2));
    }


    public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
