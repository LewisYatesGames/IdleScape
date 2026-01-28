package com.lyg.idlescape;

public class IdleScape {

    public static void main(String[] args) {
        Player player = new Player();

        player.addSkillExp(SkillType.WOODCUTTING, 13034431);
        player.addSkillExp(SkillType.FISHING, 1154);

        System.out.println("Woodcutting level: " + player.getSkillLevel(SkillType.WOODCUTTING));
        System.out.println("Woodcutting exp: " + player.getSkillExp(SkillType.WOODCUTTING));

        System.out.println("Fishing level: " + player.getSkillLevel(SkillType.FISHING));
        System.out.println("Fishing exp: " + player.getSkillExp(SkillType.FISHING));
    }

}
