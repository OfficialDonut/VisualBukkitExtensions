package com.gmail.visualbukkit.extensions.papi;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;

public class ExprPlaceholderPlayer extends Expression {

    public ExprPlaceholderPlayer() {
        super("expr-placeholder-player", "Placeholder Player", "PAPI", "The player for which a placeholder is being replaced");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.of("org.bukkit.entity.Player");
    }

    @Override
    public Block createBlock() {
        return new Block(this) {
            @Override
            public void update() {
                super.update();
                checkForPluginComponent(CompRegisterPlaceholder.class);
            }

            @Override
            public String toJava() {
                return "placeholderPlayer";
            }
        };
    }
}
