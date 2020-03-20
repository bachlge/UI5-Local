# Demo Project to show a strange behaviour and the workaround

1. create a new project by downloading a starter (Vaadin 15, Spring Boot)
2. npm install @ui5/webcomponents
3. create a java wrapper for a component:

@Tag("ui5-switch")
@JsModule("@ui5/webcomponents/dist/Switch.js")
public class Ui5Switch extends Component {

```
	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Switch.class);

	public Ui5Switch() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("textOn", "Yes");
		this.getElement().setProperty("textOff", "No");
	}

}
```

4. create a view using the component

```
@Route
@CssImport("./styles/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {

    	Ui5Switch ui5switch = new Ui5Switch();

        add(ui5switch);
    }

}
```

5. run

the application will compile without any errors
in the browser, however, an empty screen will be presented

6. Console shows one error

```
Utilities.js?ac76:2635 Uncaught (in promise) TypeError: Cannot set property 'highcharts' of undefined
    at eval (Utilities.js?ac76:2635)
    at Module.../node_modules/.pnpm/registry.npmjs.org/highcharts/6.1.4/node_modules/highcharts/js/es-modules/parts/Utilities.js (vaadin-0-3e06bc81abb8f68f7130.cache.js:6008)
    at __webpack_require__ (vaadin-bundle-be22a6ca42c2827921a5.cache.js:64)
    at eval (SvgRenderer.js?51ad:1)
    at Module.../node_modules/.pnpm/registry.npmjs.org/highcharts/6.1.4/node_modules/highcharts/js/es-modules/parts/SvgRenderer.js (vaadin-0-3e06bc81abb8f68f7130.cache.js:5948)
    at __webpack_require__ (vaadin-bundle-be22a6ca42c2827921a5.cache.js:64)
    at eval (highcharts.src.js?929e:1)
    at Module.../node_modules/.pnpm/registry.npmjs.org/highcharts/6.1.4/node_modules/highcharts/js/es-modules/masters/highcharts.src.js (vaadin-0-3e06bc81abb8f68f7130.cache.js:4880)
    at __webpack_require__ (vaadin-bundle-be22a6ca42c2827921a5.cache.js:64)
    at eval (highstock.src.js?93ac:1)
eval @ Utilities.js?ac76:2635
../node_modules/.pnpm/registry.npmjs.org/highcharts/6.1.4/node_modules/highcharts/js/es-modules/parts/Utilities.js @ vaadin-0-3e06bc81abb8f68f7130.cache.js:6008
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
eval @ SvgRenderer.js?51ad:1
../node_modules/.pnpm/registry.npmjs.org/highcharts/6.1.4/node_modules/highcharts/js/es-modules/parts/SvgRenderer.js @ vaadin-0-3e06bc81abb8f68f7130.cache.js:5948
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
eval @ highcharts.src.js?929e:1
../node_modules/.pnpm/registry.npmjs.org/highcharts/6.1.4/node_modules/highcharts/js/es-modules/masters/highcharts.src.js @ vaadin-0-3e06bc81abb8f68f7130.cache.js:4880
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
eval @ highstock.src.js?93ac:1
../node_modules/.pnpm/registry.npmjs.org/highcharts/6.1.4/node_modules/highcharts/js/es-modules/masters/highstock.src.js @ vaadin-0-3e06bc81abb8f68f7130.cache.js:4892
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
eval @ vaadin-chart.js?281b:1
../node_modules/.pnpm/registry.npmjs.org/@vaadin/vaadin-charts/6.2.4/node_modules/@vaadin/vaadin-charts/src/vaadin-chart.js @ vaadin-0-3e06bc81abb8f68f7130.cache.js:1619
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
eval @ vaadin-chart.js?a98e:1
../node_modules/.pnpm/registry.npmjs.org/@vaadin/vaadin-charts/6.2.4/node_modules/@vaadin/vaadin-charts/vaadin-chart.js @ vaadin-0-3e06bc81abb8f68f7130.cache.js:1655
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
eval @ generated-flow-imports.js?b518:1
../target/frontend/generated-flow-imports.js @ vaadin-1-e61d3eb5ec3d7ab42ccc.cache.js:184
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
Promise.catch (async)
render @ vaadin-router.js?700d:1812
__onNavigationEvent @ vaadin-router.js?700d:2231
setRoutes @ vaadin-router.js?700d:1714
eval @ index.ts?5b66:14
./index.ts @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:236
__webpack_require__ @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:64
(anonymous) @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:199
(anonymous) @ vaadin-bundle-be22a6ca42c2827921a5.cache.js:202
```

7. app works as expected if the com.vaadin artifactId is changed to vaadin-core

```
        <dependency>
            <groupId>com.vaadin</groupId>
            <!-- Replace artifactId with vaadin-core to use only free components -->
            <artifactId>vaadin</artifactId>
        </dependency>
```
