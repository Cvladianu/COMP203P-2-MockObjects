package ucl.cs.camera;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CameraTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();


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
}
