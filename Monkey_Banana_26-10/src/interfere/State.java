/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfere;

/**
 *
 * @author ADMIN
 */
public class State {

    private boolean hasStick = false;
    private boolean toChair = false;
    private boolean push = false;
    private boolean climb = false;
    private boolean hasBanana = false;

    public State() {
    }

    public boolean isHasStick() {
        return hasStick;
    }

    public void setHasStick(boolean hasStick) {
        this.hasStick = hasStick;
    }

    public boolean isToChair() {
        return toChair;
    }

    public void setToChair(boolean toChair) {
        this.toChair = toChair;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public boolean isClimb() {
        return climb;
    }

    public void setClimb(boolean climb) {
        this.climb = climb;
    }

    public boolean isHasBanana() {
        return hasBanana;
    }

    public void setHasBanana(boolean hasBanana) {
        this.hasBanana = hasBanana;
    }

    public void state() {
        if (hasStick && !toChair && !hasBanana) {
            System.out.println("   The monkey goes to the stick and still doesn't have banana");
        }
        if (!hasStick && toChair && !hasBanana) {
            System.out.println("   The monkey goes to the chair and still doesn't have banana");
        }
        if (!hasStick && !toChair && !hasBanana) {
            System.out.println("The monkey doesn't have banana");
        }
        if (hasStick && toChair && hasBanana) {
            System.out.println("The monkey has banana");
        }
        if (hasStick && toChair && !hasBanana) {
            if (!push && !climb) {
                System.out.println("   The monkey has stick and goes to the chair but still doesn't have banana");
            }
            if (push && !climb) {
                System.out.println("   The monkey pushes the chair and go to the stick but still doesn't have banana");
            }
        }
        if(!hasStick && toChair && hasBanana) {
            System.out.println("The monkey can't get banana");
        }
        if(hasStick && !toChair && hasBanana) {
            System.out.println("The monkey can't reach to banana");
        }
    }

    public void takeStick() {
        if (hasStick) {
            System.out.println("-> The monkey takes the stick");
        } else {
            System.out.println("-> The monkey doesn't take the stick");
        }
    }

    public void waveStick() {
        if (hasStick) {
            System.out.println("-> The monkey waves the stick");
        } else {
            System.out.println("-> The monkey doesn't has stick to wave");
        }
    }

    public void pushChair() {
        if (toChair) {
            System.out.println("-> The monkey pushes the chair");
        } else {
            System.out.println("-> The monkey doesn't pushes the chair");
        };
    }

    public void climbChair() {
        if (toChair) {
            System.out.println("-> The monkey climbs on the chair");
        } else {
            System.out.println("-> The monkey doesn't pushes the chair to climbs");
        }
    }
}
