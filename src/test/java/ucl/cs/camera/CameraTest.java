package ucl.cs.camera;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CameraTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  final byte[] IMG= new byte[4]
          ;
  final Sensor sensor = context.mock(Sensor.class);
  final MemoryCard memoryCard = context.mock(MemoryCard.class);
  final Camera camera = new Camera(memoryCard, sensor);

  @Test
  public void switchingTheCameraOnPowersUpTheSensor() {

    context.checking(new Expectations() {{
      oneOf(sensor).powerUp();
    }});

    camera.powerOn();

    context.assertIsSatisfied();
  }

  @Test
  public void switchingTheCameraOffPowersDownTheSensor() {

    context.checking(new Expectations() {{
      oneOf(sensor).powerDown();
    }});

    camera.powerOff();

    context.assertIsSatisfied();
  }

  @Test
  public void PressingTheShutterWhenCameraIsOnCopiesDataFromSensorToMemorycard() {

    context.checking(new Expectations() {{
        ignoring(sensor).powerUp();
      oneOf(sensor).readData(); will(returnValue(IMG));
      oneOf(memoryCard).write(IMG);
    }});

    camera.powerOn();
    camera.pressShutter();

    context.assertIsSatisfied();
  }

}
