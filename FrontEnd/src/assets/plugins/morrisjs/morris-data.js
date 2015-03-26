$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2010 Q1',
            ventas: 2666,
            transacciones: null
            
        }, {
            period: '2010 Q2',
            ventas: 2778,
            transacciones: 2294
            
        }, {
            period: '2010 Q3',
            ventas: 4912,
            transacciones: 1969
            
        }, {
            period: '2010 Q4',
            ventas: 3767,
            transacciones: 3597
            
        }, {
            period: '2011 Q1',
            ventas: 6810,
            transacciones: 1914
            
        }, {
            period: '2011 Q2',
            ventas: 5670,
            transacciones: 4293
        }, {
            period: '2011 Q3',
            ventas: 4820,
            transacciones: 3795
            
        }, {
            period: '2011 Q4',
            ventas: 15073,
            transacciones: 5967
            
            
        }, {
            period: '2012 Q1',
            ventas: 10687,
            transacciones: 4460
                    }, {
            period: '2012 Q2',
            ventas: 8432,
            transacciones: 5713
             }],
        xkey: 'period',
        ykeys: ['ventas', 'transacciones'],
        labels: ['ventas', 'transacciones'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Enero",
            value: 12
        }, {
            label: "Febrero",
            value: 30
        }, {
            label: "Marzo",
            value: 20
        }, {
            label: "Abril",
            value: 67
        }, {
            label: "Mayo",
            value: 93
        }, {
            label: "Junio",
            value: 15
        }, {
            label: "Julio",
            value: 25
        }, {
            label: "Agosto",
            value: 95
        }, {
            label: "Septiembre",
            value: 35
        }, {
            label: "Octubre",
            value: 64
        }, {
            label: "Noviembre",
            value: 100
        }, {
            label: "Diciembre",
            value: 159
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Ventas', 'Transacciones'],
        hideHover: 'auto',
        resize: true
    });

});
