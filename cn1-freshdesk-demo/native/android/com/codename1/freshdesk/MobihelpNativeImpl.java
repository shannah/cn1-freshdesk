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
import java.util.ArrayList;
import java.util.Arrays;
import android.content.Context;
import android.app.Activity;

public class MobihelpNativeImpl {
    
    com.freshdesk.mobihelp.MobihelpConfig config = new com.freshdesk.mobihelp.MobihelpConfig();
    
    
    public void config_setAutoReplyEnabled(boolean param) {
        config.setAutoReplyEnabled(param);
    }
    
    public boolean config_isPrefetchSolutions() {
        return config.getPrefetchSolutions();
    }
    
    public void config_setLaunchCountForReviewPrompt(int param) {
        config.setLaunchCountForReviewPrompt(param);
    }
    
    public String config_getAppSecret() {
        return config.getAppSecret();
    }

    public void config_setAppSecret(String param) {
        config.setAppSecret(param);
    }
    
    
    public void config_setEnhancedPrivacyModeEnabled(boolean param) {
        config.setEnhancedPrivacyModeEnabled(param);
    }

    
    public boolean config_isAutoReplyEnabled() {
        return config.isAutoReplyEnabled();
    }
    
    public void config_setPrefetchSolutions(boolean param) {
        config.setPrefetchSolutions(param);
    }

    public String config_getDomain() {
        return config.getDomain();
    }

    public void config_setDomain(String param) {
        config.setDomain(param);
    }

    public void config_setAppId(String param) {
        config.setAppId(param);
    }

    public int config_getLaunchCountForReviewPrompt() {
        return config.getLaunchCountForReviewPrompt();
    }

    public boolean config_isEnhancedPrivacyModeEnabled() {
        return config.isEnhancedPrivacyModeEnabled();
    }
    
    public int config_getFeedbackType() {
        return config.getFeedbackType().ordinal();
    }

    public void config_setFeedbackType(int param) {
        config.setFeedbackType(com.freshdesk.mobihelp.FeedbackType.values()[param]);
    }

    public String config_getAppId() {
        return config.getAppId();
    }
    
    private static Context context() {
        return com.codename1.impl.android.AndroidNativeUtil.getActivity().getApplicationContext();
    }
    
    private static Activity activity() {
        return com.codename1.impl.android.AndroidNativeUtil.getActivity();
    }
    
    public void initNative() {
        com.freshdesk.mobihelp.Mobihelp.init(context(), config);
    }

    public int getUnreadCount() {
        return com.freshdesk.mobihelp.Mobihelp.getUnreadCount(context());
    }

    public void showFeedbackWithArgs(String param, String param1) {
        com.freshdesk.mobihelp.FeedbackRequest req = new com.freshdesk.mobihelp.FeedbackRequest();
        req.setSubject(param);
        req.setDescription(param);
        com.freshdesk.mobihelp.Mobihelp.showFeedback(context(), req);
    }


    public void clearCustomData() {
        com.freshdesk.mobihelp.Mobihelp.clearCustomData(context());
    }

    

    public void clearUserData() {
        com.freshdesk.mobihelp.Mobihelp.clearUserData(context());
    }

    public void getUnreadCountAsync(final int callbackId) {
        activity().runOnUiThread(new Runnable() {
            public void run() {
                com.freshdesk.mobihelp.Mobihelp.getUnreadCountAsync(context(), new com.freshdesk.mobihelp.UnreadUpdatesCallback() {
                    public void onResult(com.freshdesk.mobihelp.MobihelpCallbackStatus status, Integer count) {
                        MobihelpNativeCallback.fireUnreadUpdatesCallback(callbackId, status.ordinal(), count);
                    }
                });
            }
        });
        
    }

    

    public void showSolutions() {
        activity().runOnUiThread(new Runnable() {
            public void run() {
                com.freshdesk.mobihelp.Mobihelp.showSolutions(context());
            }
        });
        
    }

    public void showSupport() {
        activity().runOnUiThread(new Runnable() {
            public void run() {
                com.freshdesk.mobihelp.Mobihelp.showSupport(context());
            }
        });
        
    }

    


    public void showSolutionsWithTags(String tags, String separator) {
        final ArrayList<String> tagsArr = new ArrayList<String>();
        tagsArr.addAll(Arrays.asList(tags.split(separator)));
        activity().runOnUiThread(new Runnable() {
            public void run() {
                com.freshdesk.mobihelp.Mobihelp.showSolutions(context(), tagsArr);
            }
        });
        
    }

    public void showSupportWithTags(String param, String param1) {
        final ArrayList<String> tagsArr = new ArrayList<String>();
        tagsArr.addAll(Arrays.asList(param.split(param1)));
        activity().runOnUiThread(new Runnable() {
            public void run() {
                com.freshdesk.mobihelp.Mobihelp.showSupport(context(), tagsArr);
            }
        });
        
    }

    public void addCustomDataWithSensitivity(String param, String param1, boolean param2) {
        
        com.freshdesk.mobihelp.Mobihelp.addCustomData(param, param1, param2);
    }

    public void setUserFullName(String param) {
        com.freshdesk.mobihelp.Mobihelp.setUserFullName(context(), param);
    }

    public void showAppRateDialog() {
        activity().runOnUiThread(new Runnable() {
            public void run() {
                 com.freshdesk.mobihelp.Mobihelp.showAppRateDialog(context());
            }
        });
       
    }

    public void addCustomData(String param, String param1) {
        com.freshdesk.mobihelp.Mobihelp.addCustomData(param, param1);
    }

    public void leaveBreadCrumb(String param) {
        com.freshdesk.mobihelp.Mobihelp.leaveBreadCrumb(param);
    }

    public void setUserEmail(String param) {
        com.freshdesk.mobihelp.Mobihelp.setUserEmail(context(), param);
    }

    

    public void clearBreadCrumbs() {
        com.freshdesk.mobihelp.Mobihelp.clearBreadCrumbs(context());
    }

    

    public void showConversations() {
        activity().runOnUiThread(new Runnable() {
            public void run() {
                com.freshdesk.mobihelp.Mobihelp.showConversations(context());
            }
        });
        
    }

    public void showFeedback() {
        activity().runOnUiThread(new Runnable() {
            public void run() {
                com.freshdesk.mobihelp.Mobihelp.showFeedback(context());
            }
        });
        
    }

    public boolean isSupported() {
        return true;
    }

}
