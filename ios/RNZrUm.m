
#import "RNZrUm.h"
#import <UMCommon/UMCommon.h>

@implementation RNZrUm

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (NSArray<NSString *> *)supportedEvents {
    return @[];
}

RCT_EXPORT_MODULE(RNZrUm)

RCT_EXPORT_METHOD(init:(NSString *)appKey channel:(NSString *)channel) {
    [UMConfigure initWithAppkey:appKey channel:channel];
}



@end