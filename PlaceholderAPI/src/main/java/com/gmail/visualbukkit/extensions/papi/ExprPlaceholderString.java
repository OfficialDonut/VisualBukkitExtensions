package com.gmail.visualbukkit.extensions.papi;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;

public class ExprPlaceholderString extends Expression {

    public ExprPlaceholderString() {
        super("expr-placeholder-string", "Placeholder String", "PAPI", "Replaces the placeholders in a string");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.STRING;
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("String", ClassInfo.STRING), new ExpressionParameter("Player", ClassInfo.of("org.bukkit.OfflinePlayer"))) {
            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);
                buildContext.addMavenRepository(
                        "<id>placeholderapi</id>\n" +
                        "<url>https://repo.extendedclip.com/content/repositories/placeholderapi/</url>");
                buildContext.addMavenDependency(
                        "<groupId>me.clip</groupId>\n" +
                        "<artifactId>placeholderapi</artifactId>\n" +
                        "<version>2.10.9</version>\n" +
                        "<scope>provided</scope>");
            }

            @Override
            public String toJava() {
                return "me.clip.placeholderapi.PlaceholderAPI.setPlaceholders(" + arg(1) + "," + arg(0) + ")";
            }
        };
    }
}
