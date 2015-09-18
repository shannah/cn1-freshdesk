/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */
package com.codename1.freshdesk;


import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

public class FreshDeskDemo {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        try {
            theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch(IOException e){
            e.printStackTrace();
        }
        // Pro users - uncomment this code to get crash reports sent to you automatically
        /*Display.getInstance().addEdtErrorHandler(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                evt.consume();
                Log.p("Exception in AppName version " + Display.getInstance().getProperty("AppVersion", "Unknown"));
                Log.p("OS " + Display.getInstance().getPlatformName());
                Log.p("Error " + evt.getSource());
                Log.p("Current Form " + Display.getInstance().getCurrent().getName());
                Log.e((Throwable)evt.getSource());
                Log.sendLog();
            }
        });*/
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        Form hi = new Form("Hi World");
        hi.addComponent(new Label("Hi World"));
        
        if (Mobihelp.isSupported()) {
            //MobihelpConfig *config = [[MobihelpConfig alloc]initWithDomain:@"codenameonetest1.freshdesk.com" withAppKey:@"freshdeskdemo-2-32960149eb708717db9fb8db9fcdaeb3" andAppSecret:@"3536335f585d53e285a572304c1a781ca690750b"];
            //    [[Mobihelp sharedInstance]initWithConfig:config];
            MobihelpConfig config = new MobihelpConfig();
            config.setAppSecret("3536335f585d53e285a572304c1a781ca690750b");
            config.setAppId("freshdeskdemo-2-32960149eb708717db9fb8db9fcdaeb3");
            config.setDomain("codenameonetest1.freshdesk.com");
            Mobihelp.initIOS(config);
            
            //Mobihelp.init(this,new MobihelpConfig("https://codenameonetest1.freshdesk.com", 
            //"freshdeskdemo-1-966a571049d063582333478fc40355b0", "328f6ee77c646cef2eccb6ce4c1aa49b62fddc88"));

            config = new MobihelpConfig();
            config.setAppSecret("328f6ee77c646cef2eccb6ce4c1aa49b62fddc88");
            config.setAppId("freshdeskdemo-1-966a571049d063582333478fc40355b0");
            config.setDomain("https://codenameonetest1.freshdesk.com");
            Mobihelp.initAndroid(config);
            
        }
        
        Button showSupport = new Button(new Command("Show Support") {
            public void actionPerformed(ActionEvent evt) {
                if (Mobihelp.isSupported()) {
                    Mobihelp.showSupport();
                } else {
                    Dialog.show("Unsupported", "Fresh Desk is not supported on this platform", "OK", null);
                }
            }
        });
        hi.addComponent(showSupport);
        hi.show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }

}
