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
#import "com_codename1_freshdesk_MobihelpNativeImpl.h"
#import "com_codename1_freshdesk_MobihelpNativeCallback.h"
#import "CodenameOne_GLViewController.h"


@implementation com_codename1_freshdesk_MobihelpNativeImpl

// CONFIG METHODS --------------------------------------------------------------
-(MobihelpConfig*) config {
    if (config_ == nil) {
        config_ = [[MobihelpConfig alloc] initWithDomain:nil
	withAppKey:nil
	andAppSecret:nil];
    }
    return config_;
}

-(void)config_setAutoReplyEnabled:(BOOL)param{
    [self config].enableAutoReply = param;
}


-(BOOL)config_isPrefetchSolutions{
    return [self config].prefetchSolutions;
}

-(void)config_setLaunchCountForReviewPrompt:(int)param{
    [self config].launchCountForAppReviewPrompt = param;
}

-(NSString*)config_getAppSecret{
    return [self config].appSecret;
}

-(void)config_setAppSecret:(NSString*)param{
    [self config].appSecret = param;
}

-(BOOL)config_isAutoReplyEnabled{
    return [self config].enableAutoReply;
}

-(void)config_setEnhancedPrivacyModeEnabled:(BOOL)param{
    [self config].enableEnhancedPrivacy = param;
}

-(int)config_getFeedbackType{
    return [self config].feedbackType;
}

-(void)config_setFeedbackType:(int)param{
    [self config].feedbackType = param;
}

-(NSString*)config_getAppId{
    return [self config].appKey;
}

-(void)config_setPrefetchSolutions:(BOOL)param{
    [self config].prefetchSolutions = param;
}

-(NSString*)config_getDomain{
    return [self config].domain;
}

-(void)config_setDomain:(NSString*)param{
    [self config].domain = param;
}

-(void)config_setAppId:(NSString*)param{
    [self config].appKey = param;
}

-(int)config_getLaunchCountForReviewPrompt{
    return [self config].launchCountForAppReviewPrompt;
}

-(BOOL)config_isEnhancedPrivacyModeEnabled{
    return [self config].enableEnhancedPrivacy;
}

-(void)initNative{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] initWithConfig:[self config]];
    });
    
}

// END CONFIG METHODS-----------------------------------------------------------

// BEGIN MOBIHELP METHODS ------------------------------------------------------
-(int)getUnreadCount{
    __block int out = 0;
    dispatch_sync(dispatch_get_main_queue(), ^{
        out = [[Mobihelp sharedInstance] unreadCount];
    });
    return out;
}

-(void)showFeedbackWithArgs:(NSString*)param param1:(NSString*)param1{
    [self showFeedback];
}



-(void)clearCustomData{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] clearCustomData];
    });
}


-(void)clearUserData{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] clearUserData];
    });
}

-(void)getUnreadCountAsync:(int)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] unreadCountWithCompletion:^(NSInteger count){
            com_codename1_freshdesk_MobihelpNativeCallback_fireUnreadUpdatesCallback___int_int_int(CN1_THREAD_GET_STATE_PASS_ARG param, 3 /*SUCCESS*/, count);
        }];
    });
}



-(void)showSolutions{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] presentSolutions:[CodenameOne_GLViewController instance]];
    });
}

-(void)showSupport{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] presentSupport:[CodenameOne_GLViewController instance]];
    });
}


-(void)showSolutionsWithTags:(NSString*)param param1:(NSString*)param1{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSArray* tags = [param componentsSeparatedByString:param1];
        [[Mobihelp sharedInstance] presentSolutions:[CodenameOne_GLViewController instance] withTags: tags];
#ifndef CN1_USE_ARC
        [tags release];
#endif
                
    });
}

-(void)showSupportWithTags:(NSString*)param param1:(NSString*)param1{
    [self showSupport];
}

-(void)addCustomDataWithSensitivity:(NSString*)param param1:(NSString*)param1 param2:(BOOL)param2{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] addCustomDataForKey:param withValue:param1 andSensitivity:param1];       
    });
}

-(void)setUserFullName:(NSString*)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Mobihelp sharedInstance].userName = param;     
    });
}

-(void)showAppRateDialog{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] launchAppReviewRequest];    
    });
}



-(void)addCustomData:(NSString*)param param1:(NSString*)param1{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] addCustomDataForKey:param withValue:param1];  
    });
}

-(void)leaveBreadCrumb:(NSString*)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] leaveBreadcrumb:param];    
    });
}

-(void)setUserEmail:(NSString*)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Mobihelp sharedInstance].emailAddress = param;     
    });
}

-(void)clearBreadCrumbs{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] clearBreadcrumbs];
    });
}



-(void)showConversations{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] presentInbox:[CodenameOne_GLViewController instance]];        
    });
}

-(void)showFeedback{

    dispatch_async(dispatch_get_main_queue(), ^{
        [[Mobihelp sharedInstance] presentFeedback:[CodenameOne_GLViewController instance]];        
    });
}


-(BOOL)isSupported{
    return YES;
}

// END MOBIHELP METHODS --------------------------------------------------------
@end
