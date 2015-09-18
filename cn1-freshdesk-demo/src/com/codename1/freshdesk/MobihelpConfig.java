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

/**
 *
 * @author shannah
 */
public class MobihelpConfig {
    private String appId;
    private String appSecret;
    private String domain;
    private FeedbackType feedbackType;
    private int launchCountForReviewPrompt;
    private boolean prefetchSolutions;
    private boolean autoReplyEnabled;
    private boolean enhancedPrivacyModeEnabled;

    /**
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId the appId to set
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return the appSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * @param appSecret the appSecret to set
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain the domain to set
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return the feedbackType
     */
    public FeedbackType getFeedbackType() {
        return feedbackType;
    }

    /**
     * @param feedbackType the feedbackType to set
     */
    public void setFeedbackType(FeedbackType feedbackType) {
        this.feedbackType = feedbackType;
    }

    /**
     * @return the launchCountForReviewPrompt
     */
    public int getLaunchCountForReviewPrompt() {
        return launchCountForReviewPrompt;
    }

    /**
     * @param launchCountForReviewPrompt the launchCountForReviewPrompt to set
     */
    public void setLaunchCountForReviewPrompt(int launchCountForReviewPrompt) {
        this.launchCountForReviewPrompt = launchCountForReviewPrompt;
    }

    /**
     * @return the prefetchSolutions
     */
    public boolean isPrefetchSolutions() {
        return prefetchSolutions;
    }

    /**
     * @param prefetchSolutions the prefetchOptions to set
     */
    public void setPrefetchSolutions(boolean prefetchSolutions) {
        this.prefetchSolutions = prefetchSolutions;
    }

    /**
     * @return the autoReplyEnabled
     */
    public boolean isAutoReplyEnabled() {
        return autoReplyEnabled;
    }

    /**
     * @param autoReplyEnabled the autoReplyEnabled to set
     */
    public void setAutoReplyEnabled(boolean autoReplyEnabled) {
        this.autoReplyEnabled = autoReplyEnabled;
    }

    /**
     * @return the enhancedPrivacyModeEnabled
     */
    public boolean isEnhancedPrivacyModeEnabled() {
        return enhancedPrivacyModeEnabled;
    }

    /**
     * @param enhancedPrivacyModeEnabled the enhancedPrivacyModeEnabled to set
     */
    public void setEnhancedPrivacyModeEnabled(boolean enhancedPrivacyModeEnabled) {
        this.enhancedPrivacyModeEnabled = enhancedPrivacyModeEnabled;
    }
    
}
