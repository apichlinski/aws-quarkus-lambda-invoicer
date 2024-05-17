package com.github.apichlinski.alb.boundary;

import java.util.List;
import java.util.Map;

import com.github.apichlinski.alb.control.Alb;
import com.github.apichlinski.alb.control.PublicVPC;
import com.github.apichlinski.lambda.control.QuarkusLambda;
import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.services.elasticloadbalancingv2.AddApplicationTargetsProps;
import software.amazon.awscdk.services.elasticloadbalancingv2.BaseApplicationListenerProps;
import software.amazon.awscdk.services.elasticloadbalancingv2.HealthCheck;
import software.amazon.awscdk.services.elasticloadbalancingv2.targets.LambdaTarget;
import software.constructs.Construct;

public class LambdaAlbStack extends Stack {

    static String FUNCTION_NAME  = "com_github_apichlinski_invoicer_Invoicer";

    public LambdaAlbStack(Construct scope, String id) {
        super(scope, id+"-alb-stack");
        var configuration = Map.of(
            "message", "Invoicer (Quarkus as AWS Lambda)");

        var quarkuLambda = new QuarkusLambda(this,FUNCTION_NAME,configuration);
        var publicVPCConstruct = new PublicVPC(this);
        var publicVPC = publicVPCConstruct.getVpc();
        var alb = new Alb(this, publicVPC, "InvoicerLambdaLB");

        var function = quarkuLambda.getFunction();
        var lambdaTarget = new LambdaTarget(function);
        
        var loadBalancer = alb.getApplicationLoadBalancer();
        var listener = loadBalancer.addListener("Http", BaseApplicationListenerProps.builder()
                                                                            .port(80)
                                                                            .build()); 
                                                                            
        listener.addTargets("Lambda", AddApplicationTargetsProps.builder()
                                        .targets(List.of(lambdaTarget))
                                        .healthCheck(HealthCheck.builder()
                                                        .enabled(true)
                                                        .build())
                                        .build());    
        CfnOutput.Builder.create(this, "FunctionARN").value(function.getFunctionArn()).build();
        var url = loadBalancer.getLoadBalancerDnsName();
        CfnOutput.Builder.create(this, "LoadBalancerDNSName").value(url).build();
        //CfnOutput.Builder.create(this, "LoadBalancerCurlOutput").value("curl -i http://"+url+"/hello").build();
        CfnOutput.Builder.create(this, "LoadBalancerCurlOutput").value("curl -i http://"+url+"/invoicer").build();
    }
}
