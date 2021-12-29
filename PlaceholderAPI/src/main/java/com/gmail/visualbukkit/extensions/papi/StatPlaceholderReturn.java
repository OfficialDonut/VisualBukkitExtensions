package com.gmail.visualbukkit.extensions.papi;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Statement;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

public class StatPlaceholderReturn extends Statement {

    public StatPlaceholderReturn() {
        super("stat-placeholder-return", "Placeholder Return", "PAPI", "Returns the value that will replace the placeholder");
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("Value", ClassInfo.STRING)) {
            @Override
            public void update() {
                super.update();
                checkForPluginComponent(CompRegisterPlaceholder.class);
            }

            @Override
            public String toJava() {
                return "if (true) return " + arg(0) + ";";
            }
        };
    }
}
