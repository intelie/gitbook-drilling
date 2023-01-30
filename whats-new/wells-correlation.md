# Wells correlation

{% hint style="info" %}
plugin-wells 4.0.0 minimum version required
{% endhint %}

Live provides the capability to correlate wells with symmetric association.&#x20;

First add one or more correlated wells at well parameters tab:

![Well parameters tab](<../.gitbook/assets/image (91) (1).png>)

![Correlated well option](<../.gitbook/assets/image (118).png>)



By typing a text it is possible to associate multiple wells with current well then it is possible to save:

![Search of well](<../.gitbook/assets/image (113).png>)

![Correlated wells](<../.gitbook/assets/image (364).png>)

In example, when the **Well ABC** as a correlated with **mywell**, then **mywell** will be listed as a correlated well of **Well ABC:**

![Symetric correlation](<../.gitbook/assets/image (267).png>)

To remove a correlated well click on the trash icon of the specific correlated well you want to remove and confirm. The the symmetric correlation will be removed from both wells:

![Removing correlation of a well](<../.gitbook/assets/image (53).png>)

By using the map widget it is possible to plot the coordinates of the wells to see related wells:

![Map visualization for correlated wells](<../.gitbook/assets/image (436).png>)

{% hint style="info" %}
plugin widget-maps 1.1.1  required for visualize the map on the dashboard
{% endhint %}

The query below renders the wells correlated to the well whose id is 261, for example.&#x20;

```
=> og.wellById("261")->correlatedWells:seq
|> og.wellById(_$)
|> (_->location, _->description, _->wellId) every min
=> @chain 
=> 
  location->latitude as lat,
  location->longitude as long,
  description->name as asset,
  'well' as asset_type,
  (
    description->name as caption,'
    '#/wells/'+wellId$+'/parameters' as link 
  ) as tooltip
```
