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

import com.codename1.system.NativeInterface;

/**
 *
 * @author shannah
 */
public interface MobihelpNative extends NativeInterface {

    /**
     * @return the appId
     */
    public String config_getAppId();

    /**
     * @param appId the appId to set
     */
    public void config_setAppId(String appId);

    /**
     * @return the appSecret
     */
    public String config_getAppSecret();

    /**
     * @param appSecret the appSecret to set
     */
    public void config_setAppSecret(String appSecret);
    /**
     * @return the domain
     */
    public String config_getDomain();
    /**
     * @param domain the domain to set
     */
    public void config_setDomain(String domain) ;

    /**
     * @return the feedbackType
     */
    public int config_getFeedbackType() ;

    /**
     * @param feedbackType the feedbackType to set
     */
    public void config_setFeedbackType(int feedbackType);

    /**
     * @return the launchCountForReviewPrompt
     */
    public int config_getLaunchCountForReviewPrompt() ;
    /**
     * @param launchCountForReviewPrompt the launchCountForReviewPrompt to set
     */
    public void config_setLaunchCountForReviewPrompt(int launchCountForReviewPrompt);
    /**
     * @return the prefetchSolutions
     */
    public boolean config_isPrefetchSolutions();
    /**
     * @param prefetchSolutions the prefetchOptions to set
     */
    public void config_setPrefetchSolutions(boolean prefetchSolutions);
    /**
     * @return the autoReplyEnabled
     */
    public boolean config_isAutoReplyEnabled();

    /**
     * @param autoReplyEnabled the autoReplyEnabled to set
     */
    public void config_setAutoReplyEnabled(boolean autoReplyEnabled) ;

    /**
     * @return the enhancedPrivacyModeEnabled
     */
    public boolean config_isEnhancedPrivacyModeEnabled() ;

    /**
     * @param enhancedPrivacyModeEnabled the enhancedPrivacyModeEnabled to set
     */
    public void config_setEnhancedPrivacyModeEnabled(boolean enhancedPrivacyModeEnabled) ;
    
    
    
    //Attach the given custom data (key-value pair) to the conversations/tickets.   
    public void	addCustomData(String key, String value);
    //Attach the given custom data (key-value pair) to the conversations/tickets with the ability to flag sensitive data.
    public void addCustomDataWithSensitivity(String key, String value, boolean isSensitive);
    //Clear all breadcrumb data.
    public void	clearBreadCrumbs() ;
    //Clear all custom data.
    public void	clearCustomData();
    //Clears User information.
    public void	clearUserData();
    //Retrieve the number of unread items across all the conversations for the user synchronously i.e.
    public int getUnreadCount();

    //Retrieve the number of unread items across all the conversations for the user asynchronously, count is delivered to the supplied UnreadUpdatesCallback instance Note : This may return 0 or stale value when there is no network connectivity etc
    public void	getUnreadCountAsync(int callbackId);
    
    public void initNative();
    
    //Attaches the given text as a breadcrumb to the conversations/tickets.
    public  void leaveBreadCrumb(String crumbText);
    //Set the email of the user to be reported on the Freshdesk Portal
    
    public void setUserEmail(String email);

    //Set the name of the user to be reported on the Freshdesk Portal.
    public void setUserFullName(String name);

    //Display the App Rating dialog with option to Rate, Leave feedback etc
    public void	showAppRateDialog();
    //Directly launch Conversation list screen from anywhere within the application
    public void showConversations();
    
    //Directly launch Feedback Screen from anywhere within the application.
    public void	showFeedbackWithArgs(String subject, String description);
    //Directly launch Feedback Screen from anywhere within the application.
    public void	showFeedback();
    
    //Displays the Support landing page (Solution Article List Activity) where only solutions tagged with the given tags are displayed.
    public void	showSolutionsWithTags(String tags, String separator);

    //Displays the Support landing page (Solution Article List Activity) from where users can do the following
    //View solutions,
    //Search solutions,
    public void	showSolutions();
    //Displays the Integrated Support landing page where only solutions tagged with the given tags are displayed.
    public void	showSupportWithTags(String tags, String separator);

    //Displays the Integrated Support landing page (Solution Article List Activity) from where users can do the following
    //View solutions,
    //Search solutions,
    //  Start a new conversation,
    //View existing conversations update/ unread count etc
    public void	showSupport();
    
}
