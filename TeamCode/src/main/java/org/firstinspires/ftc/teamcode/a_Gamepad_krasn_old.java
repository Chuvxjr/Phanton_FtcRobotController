package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//TODO: ПРОЛЕТАРИЙ, ПЕРЕД ТЕМЬ, КАК МЕНЯТЬ ЧТО-ТО В ГАМАПЕДЕ, ПРОВЕРЬ СНАЧАЛА МАТЬ АГАПА!!!
@TeleOp(name = "Gamepad_nov", group = "TeleOP")
public class a_Gamepad_krasn_old extends OpMode {
    DcMotor leftF, rightF, leftB, rightB, krut, pod, sos, pisun;
    CRServo zaxvat, vikidisch, pis;
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);


    @Override
    public void init() {
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        pisun = hardwareMap.dcMotor.get("pis");
        pis = hardwareMap.crservo.get("ps");
        krut = hardwareMap.dcMotor.get("kr");
        zaxvat = hardwareMap.crservo.get("zx");
        vikidisch = hardwareMap.crservo.get("vs");
        pod = hardwareMap.dcMotor.get("pod");
        sos = hardwareMap.dcMotor.get("sos");
        pis.setPower(0.1);
    }


    @Override

    public void loop() {
        float pwrTrigger = (gamepad1.left_trigger);
        float pwrTrigger2 = (gamepad1.right_trigger);
        float pwrTrigger6 = (gamepad2.left_trigger);
        float pwrTrigger5 = (gamepad2.right_trigger);
        float pwrTrigger3 = (float) (gamepad2.left_trigger * 0.66);
        float pwrTrigger4 = (float) (gamepad2.right_trigger * 0.66);
        float StickX = (float)(gamepad1.right_stick_x*0.7);
        float StickY = (float)(gamepad1.right_stick_y*0.7);
        float Stick2X = (float) (gamepad1.left_stick_x * 0.3);
        float Stick2Y = (float) (gamepad1.left_stick_y * 0.3);
        //korob.setTargetPosition(720);
        double power = -1;
        double ticks = 0;
        double x = 0;
        // занято 1 геймпад: стики , триггеры , бампера
        // занято 2 геймпад: крестовина вверх и вниз, бампера, буквы, триггеры

        if (StickY != 0 || StickX != 0) {
            leftF.setPower((+StickY - StickX) + pwrTrigger);
            leftB.setPower((+StickY + StickX) + pwrTrigger);
            rightB.setPower((-StickY + StickX) + pwrTrigger2);
            rightF.setPower((-StickY - StickX) - pwrTrigger2);
        } else if (Stick2Y != 0 || Stick2X != 0) {
            leftF.setPower((+Stick2Y - Stick2X) + pwrTrigger);
            rightB.setPower((-Stick2Y + Stick2X) + pwrTrigger2);
            rightF.setPower((-Stick2Y - Stick2X) + pwrTrigger2);
            leftB.setPower((+Stick2Y + Stick2X) + pwrTrigger);
        } else if (pwrTrigger != 0) {
            leftF.setPower(0.6 * pwrTrigger);
            rightB.setPower(0.6 * pwrTrigger);
            rightF.setPower(0.6 * pwrTrigger);
            leftB.setPower(0.6 * pwrTrigger);
        } else if (pwrTrigger2 != 0) {
            leftF.setPower(-0.6 * pwrTrigger2);
            rightB.setPower(-0.6 * pwrTrigger2);
            rightF.setPower(-0.6 * pwrTrigger2);
            leftB.setPower(-0.6 * pwrTrigger2);
        } else if (gamepad1.left_bumper) {
            leftF.setPower(0.25);
            rightB.setPower(0.25);
            rightF.setPower(0.25);
            leftB.setPower(0.25);
        } else if (gamepad1.right_bumper) {
            leftF.setPower(-0.25);
            rightB.setPower(-0.25);
            rightF.setPower(-0.25);
            leftB.setPower(-0.25);
        } else {
            leftF.setPower(0);
            rightB.setPower(0);
            rightF.setPower(0);
            leftB.setPower(0);

        }


        if (gamepad2.dpad_down){
            pod.setPower(-1);
        } else if (gamepad2.dpad_up){
            pod.setPower(1);
        } else {
            pod.setPower(0);
            pod.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (gamepad2.left_bumper){
            sos.setPower(1);
        } else if (gamepad2.right_bumper) {
            sos.setPower(-1);
        } else {
            sos.setPower(0);
        }
        if (gamepad2.b) {
            vikidisch.setPower(-1);
        }else if (gamepad2.y){
            vikidisch.setPower(-0.87);
        } else if (gamepad2.a){
            vikidisch.setPower(1);
        }else if (gamepad2.x){
            vikidisch.setPower(0.92);
        }else {
            vikidisch.setPower(0.05);
        }

        if (gamepad2.right_bumper) {
            zaxvat.setPower(-0.3);
        } else {
            zaxvat.setPower(0.53);
        }


       /* if (gamepad2.dpad_left) {
            krut.setPower(0.9);
        }
        else if (gamepad2.dpad_right){
            krut.setPower(-0.9);
        }
        else {
            krut.setPower(0);
        }*/
    }

}
      /*  if (gamepad1.start) {
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
        }
*/