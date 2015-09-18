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

import com.codename1.system.NativeLookup;
import com.codename1.ui.Display;
import java.util.ArrayList;

/**
 *
 * @author shannah
 */
public class Mobihelp {
    
    private static char[] separators = new char[]{',','|','/','@','#','%','!','^','&','*','=','+','*','<'};
    private static MobihelpNative peer;
    
    public static boolean isSupported() {
        if (peer != null) {
            return peer.isSupported();
        } else {
            try {
                MobihelpNative n = (MobihelpNative)NativeLookup.create(MobihelpNative.class);
                return n.isSupported();
            } catch (Throwable ex) {
                return false;
            }
        }
    }
    
    public static void setPeer(MobihelpNative peer) {
        Mobihelp.peer = peer;
    }
    
    //Attach the given custom data (key-value pair) to the conversations/tickets.   
    final static void	addCustomData(String key, String value) {
        peer.addCustomData(key, value);
    }
    //Attach the given custom data (key-value pair) to the conversations/tickets with the ability to flag sensitive data.
    final static void	addCustomData(String key, String value, boolean isSensitive) {
        peer.addCustomDataWithSensitivity(key, value, isSensitive);
    }
    //Clear all breadcrumb data.
    final static void	clearBreadCrumbs() {
        peer.clearBreadCrumbs();
    }
    //Clear all custom data.
    final static void	clearCustomData() {
        peer.clearCustomData();
    }
    //Clears User information.
    final static void	clearUserData() {
        peer.clearUserData();
    }
    //Retrieve the number of unread items across all the conversations for the user synchronously i.e.
    final static int	getUnreadCount() {
        return peer.getUnreadCount();
    }

    //Retrieve the number of unread items across all the conversations for the user asynchronously, count is delivered to the supplied UnreadUpdatesCallback instance Note : This may return 0 or stale value when there is no network connectivity etc
    final static void	getUnreadCountAsync(UnreadUpdatesCallback callback) {
        int callbackId = MobihelpNativeCallback.registerUnreadUpdatesCallback(callback);
        peer.getUnreadCountAsync(callbackId);
    }
    //Initialize the Mobihelp support section with necessary app configuration.
    final static void	initAndroid(MobihelpConfig config) {
        if ("and".equals(Display.getInstance().getPlatformName())) {
            init(config);
        }
    }
    
    final static void initIOS(MobihelpConfig config) {
        if ("ios".equals(Display.getInstance().getPlatformName())) {
            init(config);
        }
    }
    
    private static void init(MobihelpConfig config) {
        peer = (MobihelpNative)NativeLookup.create(MobihelpNative.class);
        peer.config_setAppId(config.getAppId());
        peer.config_setAppSecret(config.getAppSecret());
        peer.config_setAutoReplyEnabled(config.isAutoReplyEnabled());
        peer.config_setDomain(config.getDomain());
        peer.config_setEnhancedPrivacyModeEnabled(config.isEnhancedPrivacyModeEnabled());
        if (config.getFeedbackType() != null) {
            peer.config_setFeedbackType(config.getFeedbackType().ordinal());
        }
        peer.config_setLaunchCountForReviewPrompt(config.getLaunchCountForReviewPrompt());
        peer.config_setPrefetchSolutions(config.isPrefetchSolutions());
        peer.initNative();
        
    }
    
    //Attaches the given text as a breadcrumb to the conversations/tickets.
    final static void	leaveBreadCrumb(String crumbText) {
        peer.leaveBreadCrumb(crumbText);
    }
    //Set the email of the user to be reported on the Freshdesk Portal
    final static void	setUserEmail(String email) {
        peer.setUserEmail(email);
    }

    //Set the name of the user to be reported on the Freshdesk Portal.
    final static void	setUserFullName(String name) {
        peer.setUserFullName(name);
    }

    //Display the App Rating dialog with option to Rate, Leave feedback etc
    static void	showAppRateDialog() {
        peer.showAppRateDialog();
    }
    //Directly launch Conversation list screen from anywhere within the application
    final static void	showConversations() {
        peer.showConversations();
    }
    //Directly launch Feedback Screen from anywhere within the application.
    final static void	showFeedback(FeedbackRequest feedbackRequest) {
        peer.showFeedbackWithArgs(feedbackRequest.getSubject(), feedbackRequest.getDescription());
    }
    //Directly launch Feedback Screen from anywhere within the application.
    final static void	showFeedback() {
        peer.showFeedback();
    }
    //Displays the Support landing page (Solution Article List Activity) where only solutions tagged with the given tags are displayed.
    final static void	showSolutions(ArrayList<String> tags) {
        String separator = findUnusedSeparator(tags);
        StringBuilder sb = new StringBuilder();
        for (String tag : tags) {
            sb.append(tag).append(separator);
        }
        peer.showSolutionsWithTags(sb.toString().substring(0, sb.length()-separator.length()), separator);
    }

    private static String findUnusedSeparator(ArrayList<String> tags) {
        StringBuilder sb = new StringBuilder();
        for (String tag : tags) {
            sb.append(tag);
        }
        String sbStr = sb.toString();
        for (char c : separators) {
            if (sbStr.indexOf(c) == -1) {
                return String.valueOf(c);
            }
        }
        
        // Could not find single char separator... just create a string 
        // long enough that will be used as a separator.
        String sep = "#";
        while (sbStr.indexOf(sep) != -1) {
            sep += "#";
        }
        return sep;
        
    }
    
    //Displays the Support landing page (Solution Article List Activity) from where users can do the following
    //View solutions,
    //Search solutions,
    final static void	showSolutions() {
        peer.showSolutions();
    }
    //Displays the Integrated Support landing page where only solutions tagged with the given tags are displayed.
    final static void	showSupport(ArrayList<String> tags) {
        String separator = findUnusedSeparator(tags);
        StringBuilder sb = new StringBuilder();
        for (String tag : tags) {
            sb.append(tag).append(separator);
        }
        peer.showSupportWithTags(sb.toString().substring(0, sb.length()-separator.length()), separator);
    }

    //Displays the Integrated Support landing page (Solution Article List Activity) from where users can do the following
    //View solutions,
    //Search solutions,
    //  Start a new conversation,
    //View existing conversations update/ unread count etc
    final static void	showSupport() {
        peer.showSupport();
    }

}
