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
#import <Foundation/Foundation.h>
#import "Mobihelp.h"

@interface com_codename1_freshdesk_MobihelpNativeImpl : NSObject {
    MobihelpConfig *config_; 
}

-(void)initNative;
-(int)getUnreadCount;
-(void)showFeedbackWithArgs:(NSString*)param param1:(NSString*)param1;
-(void)config_setAutoReplyEnabled:(BOOL)param;
-(void)clearCustomData;
-(BOOL)config_isPrefetchSolutions;
-(void)clearUserData;
-(void)getUnreadCountAsync:(int)param;
-(void)config_setLaunchCountForReviewPrompt:(int)param;
-(void)showSolutions;
-(void)showSupport;
-(NSString*)config_getAppSecret;
-(void)config_setAppSecret:(NSString*)param;
-(BOOL)config_isAutoReplyEnabled;
-(void)showSolutionsWithTags:(NSString*)param param1:(NSString*)param1;
-(void)showSupportWithTags:(NSString*)param param1:(NSString*)param1;
-(void)addCustomDataWithSensitivity:(NSString*)param param1:(NSString*)param1 param2:(BOOL)param2;
-(void)setUserFullName:(NSString*)param;
-(void)showAppRateDialog;
-(void)config_setEnhancedPrivacyModeEnabled:(BOOL)param;
-(void)addCustomData:(NSString*)param param1:(NSString*)param1;
-(void)leaveBreadCrumb:(NSString*)param;
-(void)setUserEmail:(NSString*)param;
-(void)config_setPrefetchSolutions:(BOOL)param;
-(NSString*)config_getDomain;
-(void)config_setDomain:(NSString*)param;
-(void)config_setAppId:(NSString*)param;
-(int)config_getLaunchCountForReviewPrompt;
-(BOOL)config_isEnhancedPrivacyModeEnabled;
-(void)clearBreadCrumbs;
-(int)config_getFeedbackType;
-(void)config_setFeedbackType:(int)param;
-(NSString*)config_getAppId;
-(void)showConversations;
-(void)showFeedback;
-(BOOL)isSupported;
@end
