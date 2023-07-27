
#import "RNZrUm.h"
#import <UMCommon/UMCommon.h>

#import <UMAPM/UMLaunch.h>
#import <UMAPM/UMCrashConfigure.h>
#import <UMAPM/UMAPMConfig.h>

@implementation RNZrUm

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (NSArray<NSString *> *)supportedEvents {
    return @[];
}

RCT_EXPORT_MODULE(RNZrUm)

RCT_EXPORT_METHOD(initUM) {
    NSDictionary * dic =  [[NSBundle mainBundle] infoDictionary];
    NSString * appKey = dic[@"UM_APPKEY"];
    NSString * channel = dic[@"UM_CHANNEL"];
    [UMConfigure initWithAppkey:appKey channel:channel];
}

RCT_EXPORT_METHOD(setCrash:(NSString *)error) {
    [UMCrashConfigure reportExceptionWithName:@"主动上报" reason:error stackTrace:@[]];
}


@end
  
