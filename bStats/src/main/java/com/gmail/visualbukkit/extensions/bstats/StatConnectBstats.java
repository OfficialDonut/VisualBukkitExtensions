package com.gmail.visualbukkit.extensions.bstats;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Statement;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public class StatConnectBstats extends Statement {

    public StatConnectBstats() {
        super("stat-connect-bstats", "Connect To bStats", "bStats", "Connects the plugin to bStats");
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("ID", ClassInfo.INT)) {
            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);
                buildContext.addUtilClass(Roaster.parse(JavaClassSource.class, BstatsExtension.METRICS_CLASS));
            }

            @Override
            public String toJava() {
                return "new Metrics(PluginMain.getInstance()," + arg(0) + ");";
            }
        };
    }
}
