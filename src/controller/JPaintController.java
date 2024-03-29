package controller;


import main.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    ShapeList shapelist =  ShapeList.getInstance();



    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;

    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().runCommand());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().runCommand());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand().runCommand());
        uiModule.addEvent(EventName.COPY, () -> new CopiedShapesList().setCopied());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapeCommand().runCommand());
        uiModule.addEvent(EventName.GROUP, () -> shapelist.groupShapes());
        uiModule.addEvent(EventName.UNGROUP, () -> shapelist.ungroupShapes());
    }
}
