# BOP Schematic

The BOP Schematic feature provides the interface to show the BOP schema and track your components status in real time.

![BOP schematic example](<../../.gitbook/assets/image (131).png>)

![Bop Schematic Widget](../../.gitbook/assets/image1.png)

A BOP Schematic is always associated with a Rig, so it is created and edited in the Rig parameters, at the BOP Configuration area.

![Configured Schematic view in the Rig parameters.](<../../.gitbook/assets/image (101).png>)

The BOP schematic widget is where the configured schema, with real time status of the components, will be displayed.

![Bop Schematic Widget, with updated components status](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2F-Lno5CP\_Y4IUtBWLlJZl%2Fuploads%2FyJHrif5eLGfOncby30LY%2Fimage1.png?alt=media\&token=92fe697a-361d-41be-aecb-6283bc12f394)

Now, see how to configure a BOP Schematic and how to properly use all the features of this tool.

### **How to configure from Schematic BOP**&#x20;

At the rig parameters tab it is possible to configure BOP for each rig:

![Configured Schematic view in the Rig parameters. The schematic in the Rig Parameters don't have any information about the status of the components.](<../../.gitbook/assets/image (116).png>)

Clicking on the edit button of the BOP configuration card will open a new window where is possible to start a new BOP from basic template or import from another rig or JSON files.

![Import or start from basic template.](../../.gitbook/assets/image4.png)

### **Starting from basic template**

When starting from a basic template, it starts with two fixed components, Kill/Choke and Mud Boost, present in all other schemes:

![Basic template loaded](<../../.gitbook/assets/image (107).png>)

Clicking in “ + Add Component ” a new component will be appended in the schematic and the configuration screen will open with the options to configure:

![Basic template with one component added](<../../.gitbook/assets/image (114).png>)

The component in the left side automatically changes while the Component Details are defined at the form in the right like the component and its type and name:

![Component at the left changes while the configuration at the right is changing](<../../.gitbook/assets/image (140).png>)

The status of the components can be controlled by the annotations. The Component Data area, at the right, is where the “Source of data” and “Status allowed” are defined. For now, only the annotations are enabled as source of data:

![Annotation as source of the component data](<../../.gitbook/assets/image (119).png>)

Is also possible to reorder the components by clicking and dragging on the handler icon. After changes, save the BOP Schematic by clicking on the Save button:

![Drag and drop to reorder the components](<../../.gitbook/assets/image (166).png>)

The BOP Schematic will be displayed in the rig parameters. At this point, in the rig parameters, the status of the components are not displayed yet. For that it is necessary to open the schematic inside the BOP Schematic Widget.

![Bop Schematic in the rig parameter after save.](<../../.gitbook/assets/image (161).png>)

### **Exporting Schematic BOP**&#x20;

To export the Schematic open the edit screen and click on Export:

![Export button](<../../.gitbook/assets/image (99).png>)

Choose the type you want to export and Save. The file will be automatically downloaded.

![Export options](<../../.gitbook/assets/image (108).png>)

For now, only the JSON format is enabled to export.

### **Importing Schematic BOP from another rig**&#x20;

To import BOP Schematic from another Rig, go to the Rig you want to configure, click to edit BOP Schematic and click on the Import button.

![Import button](<../../.gitbook/assets/image (125).png>)

At the import modal, select “Copy configuration from another rig”, then select the rig you want to import the data, and click to import.

![Import from another rig](<../../.gitbook/assets/image (106).png>)

![List of rigs to import](<../../.gitbook/assets/image (160).png>)

The schematic imported will be displayed in the edit mode. To save the changes click on the Save button.

### **Importing Schematic BOP from JSON**&#x20;

To import BOP Schematic from JSON, go to the Rig you want to configure, click to edit BOP Schematic and click on the Import button.

![Import options](<../../.gitbook/assets/image (146).png>)

At the import modal, select “JSON”. It is possible to drop a file or paste the JSON from the clipboard. If JSON is valid, click "Import", check the configuration you just imported and then click "Save".

### **BOP Schematic Widget (real time component status)**&#x20;

To include the chart go to edit mode at the dashboard and the option for BOP schematic widget will be available

![Standard chart option to include BOP schematic widget](<../../.gitbook/assets/image (97).png>)

It is possible configure the chart to select the rig by available rigs list

![BOP Schematic widget in edit mode](<../../.gitbook/assets/image (144).png>)

You can also configure the visibility of component names. They can be always visible or only visible when the cursor is over a component.

![Option 'View when mouse over' selected](<../../.gitbook/assets/image (122).png>)

If there's no annotation status for the selected rig, the schematic represents the components as 'no data', like the image below:

![BOP Schematic with no status annotation (no status)](<../../.gitbook/assets/image (95).png>)

### **How to update status using annotations**&#x20;

At the dashboard, click on the timeline, select "+ Create" and then select "Register BOP status":

!['Register BOP Status' option in the annotations. ](<../../.gitbook/assets/image (105).png>)

In the next screen it is possible to select the desired rig and well. If the selected rig has no components registered, as per previous steps, no component will be displayed and the note cannot be saved.

If the rig has components registered, the list of components **with defined data source** will be present in the list:

![List of components to set the status](<../../.gitbook/assets/image (123).png>)

Select the state for each of the components and click save. After saving, the note will be highlighted in the timeline. Clicking on this indicator will display the basic information of the note.

![Components status updated by 'BOP Register' annotation](<../../.gitbook/assets/image (126).png>)

For more information about BOP Status register access [https://drilling.intelie.com/whats-new/bop-status-register](bop-status-register.md)
